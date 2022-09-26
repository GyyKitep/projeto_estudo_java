FROM openjdk:17-oracle
RUN addgroup --system spring && adduser --system spring -G spring 
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Xmx512m","-Dserver.port=${PORT}"-jar","/app.jat"]

#comando para rodar a imagem
#docker run -p 8080:8080 -e
#SPRING_PROFILES_ACTIVE='prod' -e
#FORUM_DATABASE_URL='jdbc:h2:mem:forum'
#-e FORUM_dATABASE_USERNAME='sa' -e
#FORUM_DATABASE_PASSWORD='' -e
#FORUM_JWT_SECRET='123456' (imagem)