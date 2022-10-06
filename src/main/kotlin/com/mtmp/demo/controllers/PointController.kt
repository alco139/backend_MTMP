package com.mtmp.demo.controllers

import com.mtmp.demo.models.Point
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin

@RestController
@RequestMapping("api")
class PointController {

    @GetMapping("/data")
    fun getData(@RequestParam speed: Double, @RequestParam angle: Double): MutableList<Point> {
        var x = 0.0
        var y = 0.0
        var time : Double = 0.0
        val points = mutableListOf<Point>()
        val radianAngle = angle * 3.14 / 180

        do {
            points.add(Point(x,y,time))
            time += 0.1
            x = speed * time * cos(radianAngle)
            y = (speed * time * sin(radianAngle)) - (9.78 * time.pow(2) / 2)

        }while (y > 0)
        val distance = speed.pow(2) / 9.78 * sin(radianAngle*2)
        points.add(Point(distance, 0.0, time))
        println(points)
        return points
    }
    @PostMapping("/ahoj")
    fun ahoj(): String{
        println("ahoj")
        return "hello world"
    }
}