package com.example.torang_core.util

import android.content.Context
import android.os.Environment
import android.util.Log
import android.widget.Toast
import java.io.File
import java.io.FileOutputStream
import java.io.PrintStream
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

/**
 * 태그 설계
 * 1. 파일 쓰기 기능 날짜별로
 * 2. v, d, i, w, e 기능 정리
 *
 *
 * 로그의 우선순위
 * 우선순위는 다음 값 중 하나입니다.
 * V — Verbose (가장 낮은 우선순위)
 * D — Debug
 * I — Info
 * W — Warning
 * E — Error
 * A — Assert
 *
 *
 * Log level 메뉴에서 다음 값 중 하나를 선택합니다.
 * Verbose - 모든 로그 메시지를 표시합니다(기본 설정).
 * Debug - 개발 중에만 유용한 디버그 로그 메시지뿐 아니라 더 낮은 레벨의 메시지도 이 목록에 표시합니다.
 * Info - 일반적인 사용에 대해 예상할 수 있는 로그 메시지뿐 아니라 더 낮은 레벨의 메시지도 이 목록에 표시합니다.
 * Warn - 아직 오류는 아니지만 발생 가능한 문제뿐 아니라 더 낮은 레벨의 메시지도 이 목록에 표시합니다.
 * Error - 오류를 일으킨 문제뿐 아니라 더 낮은 레벨의 메시지도 이 목록에 표시합니다.
 * Assert - 개발자가 결코 발생해서는 안 된다고 생각하는 문제를 표시합니다.
 */
object Logger {
    var TAG = "__torang"
    var isWriteFile = false
    var path = Environment.getExternalStorageDirectory().path

    fun writeFile(data: String) {
        if (!isWriteFile) return
        try {
            val simpleDateFormat = SimpleDateFormat("YYYY-MM-dd")
            val filename = simpleDateFormat.format(Date(System.currentTimeMillis()))
            val folder = File(path + "/torang/")
            if (!folder.exists() && !folder.mkdirs()) {
                //Log.d(TAG, "folder create failed:" + folder.getPath());
                return
            }
            val file = File(path + "/torang/" + filename + ".txt")
            val fileinput = FileOutputStream(file, true)
            val printstream = PrintStream(fileinput)
            printstream.print(
                """
    $data
    
    """.trimIndent()
            )
            fileinput.close()
        } catch (e: Exception) {
            Log.v(TAG, e.toString())
        }
    }

    /**
     * V — Verbose (가장 낮은 우선순위)
     * Verbose - 모든 로그 메시지를 표시합니다(기본 설정).
     *
     * @param str
     */
    fun v(str: Any) {
        run {
            val stack = Throwable().stackTrace
            val currentStack = stack[1]
            val log =
                currentStack.fileName + "::" + currentStack.methodName + "(" + currentStack.lineNumber + ")" + ": " + str
            Log.v(TAG, log)
            writeFile(log)
        }
    }

    /**
     * D — Debug
     * Debug - 개발 중에만 유용한 디버그 로그 메시지뿐 아니라 더 낮은 레벨의 메시지도 이 목록에 표시합니다.
     *
     * @param str
     */
    fun d(str: Any) {
        run {
            val stack = Throwable().stackTrace
            val currentStack = stack[1]
            val log =
                currentStack.fileName + "::" + currentStack.methodName + "(" + currentStack.lineNumber + ")" + ": " + str
            Log.d(TAG, log)
            writeFile(log)
        }
    }

    /**
     * I — Info
     * Info - 일반적인 사용에 대해 예상할 수 있는 로그 메시지뿐 아니라 더 낮은 레벨의 메시지도 이 목록에 표시합니다.
     */
    fun i(str: Any) {
        run {
            val stack = Throwable().stackTrace
            val currentStack = stack[1]
            val log =
                currentStack.fileName + "::" + currentStack.methodName + "(" + currentStack.lineNumber + ")" + ": " + str
            Log.v(TAG, log)
            writeFile(log)
        }
    }

    /**
     * W — Warning
     * Warn - 아직 오류는 아니지만 발생 가능한 문제뿐 아니라 더 낮은 레벨의 메시지도 이 목록에 표시합니다.
     *
     * @param str
     */
    fun w(str: Any) {
        run {
            val stack = Throwable().stackTrace
            val currentStack = stack[1]
            val log =
                currentStack.fileName + "::" + currentStack.methodName + "(" + currentStack.lineNumber + ")" + ": " + str
            Log.w(TAG, log)
            writeFile(log)
        }
    }

    /**
     * E — Error
     * Error - 오류를 일으킨 문제뿐 아니라 더 낮은 레벨의 메시지도 이 목록에 표시합니다.
     *
     * @param str
     */
    fun e(str: Any) {
        run {
            val stack = Throwable().stackTrace
            val currentStack = stack[1]
            val log =
                currentStack.fileName + "::" + currentStack.methodName + "(" + currentStack.lineNumber + ")" + ": " + str
            Log.e(TAG, log)
            writeFile(log)
        }
    }

    fun t(c: Context?, str: Any) {
        run { Toast.makeText(c, "" + str, Toast.LENGTH_LONG).show() }
    }

    fun api(str: String) {
        var str = str
        run {
            val stack = Throwable().stackTrace
            val currentStack = stack[1]
            val buffer = StringBuffer()
            str = str.replace("\"", "")
                .replace(",", "\n")
                .replace("{", "")
                .replace("}", "")
                .replace("\\u003d", "=")
            buffer.append("$str\n//info")
            Log.d(
                "exceptiontag",
                currentStack.fileName + "::" + currentStack.methodName + "(" + currentStack.lineNumber + ")" + ": " + buffer.toString()
            )
        }
    }
}