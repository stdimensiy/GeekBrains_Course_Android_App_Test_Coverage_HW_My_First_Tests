package com.geekbrains.myfirsttests

class TextConverter {
    // метод принимает на вход две строки (имя и отчество) должен убрать все лишнее
    // соединить строки через пробел и вернуть результат в виде Имени и Отчества где первая буква
    // каждого слова всегда заглавная
    fun nameConnector(firstName: String, lastName: String): String{
        return "$firstName $lastName"
    }

    //метод преобразовывает строку в число или выдает Null если строка не может быть
    // корректно преобразована в Long

    fun stringToLong(str: String): Long?{
        return str.toLongOrNull()
    }
}