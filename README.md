# Методы вычислений — лабораторные работы

Java 17, Maven. Каждая лаба — отдельный модуль.

| Лаба | Модуль | Тема |
|------|--------|------|
| 1 | [lab1-square-root](lab1-square-root) | СЛАУ методом квадратного корня |

## Запуск

```bash
mvn package
java -jar lab1-square-root/target/lab1-square-root-1.0.jar
```

Без Maven:

```bash
javac -d out lab1-square-root/src/main/java/lab1/*.java
java -cp out lab1.Main
```

## Новая лаба

1. Создать папку `labN-<тема>` со своим `pom.xml` (parent — корневой pom).
2. Добавить `<module>labN-<тема></module>` в корневой `pom.xml`.
3. Дописать строку в таблицу выше.
