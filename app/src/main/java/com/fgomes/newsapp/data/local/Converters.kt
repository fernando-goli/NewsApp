package com.fgomes.newsapp.data.local

import androidx.room.TypeConverter
import com.fgomes.newsapp.data.models.Source

class Converters {
    /**
     * Conversor de tipo quando esta utilizando o mesmo model para o Room e Retrofit,
     * conversor é criado para Room interpretar a classe e converter tipos que não sejam
     * primitivos ou string, ex: class Source
     * */
    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }
}