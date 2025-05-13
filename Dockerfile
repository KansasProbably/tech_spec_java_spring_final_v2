
# Шаг 1: Используем образ с Maven и OpenJDK для сборки
FROM maven:3.8.1-openjdk-17 as build

# Устанавливаем рабочую директорию для сборки
WORKDIR /app

# Копируем файл pom.xml и скачиваем зависимости
COPY pom.xml .
RUN mvn dependency:go-offline

# Копируем исходные файлы
COPY src ./src

# Шаг 2: Собираем приложение (JAR файл)
RUN mvn clean package -DskipTests

# Шаг 3: Используем образ с JRE для запуска приложения
FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию для финального контейнера
WORKDIR /app

# Копируем собранный JAR файл из первого этапа
COPY --from=build /app/target/*.jar app.jar

# Открываем порт 8080
EXPOSE 8080

# Шаг 4: Запускаем приложение
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
