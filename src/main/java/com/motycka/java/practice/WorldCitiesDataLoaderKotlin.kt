package com.motycka.java.practice

import com.motycka.java.practice.lesson6.CapitalType
import com.motycka.java.practice.lesson6.WorldCity
import java.io.File


private const val filePath = "/Users/monikaprotivova/IdeaProjects/Playground/java-programming-course/src/main/resources/worldcities.csv"
fun main() {

    val file = File(filePath)

    val cities = file.readLines().drop(1)
        .map { line: String ->
            val columns = line.split("\\|".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            WorldCity(
                columns[1],
                columns[4],
                columns[2].toDouble(),
                columns[3].toDouble(),
                columns[5],
                columns[6],
                columns[8].toCityType(),
                if (columns[9].isBlank()) 0 else columns[9].toDouble().toLong() // TODO downcasting
            )
        }.toList()

    println("Countries by number of cities:")
    cities.countriesByNumberOfCities()
        .forEach { (country: String, numberOfCities: Int) ->
            println("$country - $numberOfCities")
        }
}

private fun List<WorldCity>.byCountry(): Map<String, List<WorldCity>> {
    return groupBy { it.country }
}

private fun List<WorldCity>.countriesByNumberOfCities(): Map<String, Int> {
    return groupBy { it.country }
        .map { (country, cities) -> country to cities.size }
        .sortedBy { (_, count) -> count }
        .reversed()
        .toMap()
}

private fun String.toCityType() = when (this) {
    "primary" -> CapitalType.PRIMARY
    "admin" -> CapitalType.ADMIN
    "minor" -> CapitalType.MINOR
    else -> CapitalType.NONE
}
