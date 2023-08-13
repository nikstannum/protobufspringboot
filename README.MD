### This commit describes how to use proto files to generate DTOs that are used as web-interface entities. An example of POJO <---> DTO mapping is also given. Note that the "manual" mapping code is commented out. The main interest is mapping using the MapStruct library.

#### How to use:

##### 1. Modify the description of the proto file slightly to be used as a DTO. Note that only the field names that match the field names of the POJO classes have been changed.

Also note that the value UNSPECIFIED has been added to the PhoneTypeDto enum. This is done to avoid confusion if the
client fails to send the request body. For example, earlier, if you send a POST request with a body like this
{
"course_name": "REST with Spring",
"students": [
{
"id": 1,
"first_name": "John",
"last_name": "Doe",
"email": "johndoe@example.com",
"phones": [
{
"number": "555-1234"
}
]
},
{
"id": 2,
"first_name": "Jane",
"last_name": "Doe",
"email": "janedoe@example.com",
"phones": [
{
"number": "555-5678",
"type": "LANDLINE"
}
]
}
]
}
the student with id = 1 will have MOBILE installed by default (you can go back to this point and make sure). Now, if you
do not specify the phone type, an exception will be thrown (see https://protobuf.dev/programming-guides/style/#enums)

##### 2. The mechanism for compiling and generating classes based on proto-files remains unchanged and is described in the README.MD of the previous commit.

##### 3. Pay attention to the fact that in the generated classes the words 'list' (students --> studentsList) are added to the names of the fields in the proto-files, which are collections (in this case, List).

##### 4. Pay attention to the comments to the code, which affect the nuances of the generated classes with the MapStruct library.

### В этом коммите описано использование прото-файлов для генерации DTO, которые используются в качестве сущностей веб-интерфейса. Также приводится пример маппинга POJO <---> DTO. Обратите внимание, что код маппинг "вручную" закомментирован. Основной интерес представляет маппинг с использованием библиотеки MapStruct.

#### Порядок использования:

##### 1. Немного измените описание прото-файла для использования в качестве DTO. Обратите внимание, что изменены только имена полей, которые соответствуют именам полей POJO-классов.

Также обратите внимание, что в enum PhoneTypeDto добавлено значение UNSPECIFIED. Это сделано для того, чтобы не
допустить путаницы при ошибке передачи клиентом тела запроса. Например, раньше, если послать POST запрос с таким телом
{
"course_name": "REST with Spring",
"students": [
{
"id": 1,
"first_name": "John",
"last_name": "Doe",
"email": "johndoe@example.com",
"phones": [
{
"number": "555-1234"
}
]
},
{
"id": 2,
"first_name": "Jane",
"last_name": "Doe",
"email": "janedoe@example.com",
"phones": [
{
"number": "555-5678",
"type": "LANDLINE"
}
]
}
]
}
у студента с id = 1 телефон по умолчанию будет установлен MOBILE (можете вернуться к этому моменту и убедиться). Теперь
же, если не указать тип телефона, то будет брошено исключение (см. https://protobuf.dev/programming-guides/style/#enums)

##### 2. Механизм компиляции и генерации классов на основе прото-файлов остался без изменений и описан в README.MD предыдущего коммита.

##### 3. Обратите внимание на то, что в сгенерированных классах к именам полей в прото-файлах, представляющих собой колекции (в данном случае List), добавлены слова 'list' (students --> studentsList).

##### 4. Обратите внимание на комментарии к коду, которые затрагивают нюансы работы сгенерированных классов с библиотекой MapStruct.



