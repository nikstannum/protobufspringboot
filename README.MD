### Demo application for using proto files (On the example of the tutorial https://www.baeldung.com/spring-rest-api-with-protocol-buffers)
#### How to use:
##### 1. Download the protoc compiler to compile .proto files. Add it to environment variables. Run the protoc command on the command line to verify that the compiler is working.
You can download the compiler for your OS at the URL https://github.com/protocolbuffers/protobuf/releases
##### 2. Create a course.proto file in the resources folder with a description of the required class fields.
##### 3. Compile the course.proto file with the command 'protoc --java_out=src/main/java src/main/resources/course.proto'.
The command parameters are the directory (src/main/java) where the generated class will be placed and the path to the course.proto file.
Note that the package for the generated class is defined in the course.proto file.
You can also compile the proto file with the command 'protoc --proto_path=src/main/resources --java_out=src/main/java course.proto', in which the directory where the proto file is located is specified as the first argument, and in as the second, the destination directory to contain the generated class. Here, too, the package for the generated class is taken from the description of the course.proto file.
##### 4. Description of dependencies in the project:
implementation 'com.google.protobuf:protobuf-java:3.24.0' - needed to work with protobuf objects
implementation 'com.googlecode.protobuf-java-format:protobuf-java-format:1.4' - needed to work with the JSON representation of protobuf objects.
##### 5. Note that by default the controller serializes the object to application/x-protobuf format (see https://docs.spring.io/spring-framework/docs/current/javadoc-api/org /springframework/http/converter/protobuf/ProtobufHttpMessageConverter.html). In order to serialize an object to JSON, you need to register a ProtobufHttpMessageConverter as a bean and add the 'com.googlecode.protobuf-java-format:protobuf-java-format:1.4' dependency that supports object serialization to JSON. After that, the contentType must be explicitly specified in the controller.



### Демонстрационное приложение для использования прото-файлов
#### Порядок использования:
##### 1. Скачать компилятор protoc для компиляции файлов .proto. Добавить его в переменные среды. Исполнить команду protoc в командной строке, чтобы убедиться в работоспособности компилятора.
Скачать компилятор для Вашей ОС можно по URL https://github.com/protocolbuffers/protobuf/releases
##### 2. Создать файл course.proto в папке resources с описанием полей требуемого класса.
##### 3. Скомпилировать файл course.proto с помощью команды 'protoc --java_out=src/main/java src/main/resources/course.proto'.
Параметрами команды является директория (src/main/java), куда будет помещен сгенерированный класс и путь к файлу course.proto.
Обратите внимание, что пакет для сгенерированного класса определен в файле course.proto.
Также скомпилировать прото-файл можно командой 'protoc --proto_path=src/main/resources --java_out=src/main/java course.proto', в которой в качестве первого аргумента указана директория, в которой расположен прото-файл, а в качестве второго - директория назначения для размещения сгенерированного класса. Здесь также пакет для сгенерированного класса берется из описания файла course.proto.
##### 4. Описание зависимостей в проекте:
implementation 'com.google.protobuf:protobuf-java:3.24.0' - нужна для работы с protobuf-объектами
implementation 'com.googlecode.protobuf-java-format:protobuf-java-format:1.4' - нужна для работы с JSON-представлением protobuf-объектов.
##### 5. Обратите внимание, что по умолчанию в контроллере объект сериализируется в формат application/x-protobuf (см. https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/http/converter/protobuf/ProtobufHttpMessageConverter.html). Для того, чтобы сериализовать объект в JSON, необходтмо зарегистрировать в качестве бина ProtobufHttpMessageConverter и добавить зависимость 'com.googlecode.protobuf-java-format:protobuf-java-format:1.4', которая поддерживает сериализацию объекта в JSON. После этого в контроллере необходимо явно указать contentType.



