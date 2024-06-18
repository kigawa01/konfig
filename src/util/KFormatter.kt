package util

import net.kigawa.kutil.kutil.string.StringColor
import java.util.*
import java.util.logging.Formatter
import java.util.logging.LogRecord


class KFormatter : Formatter() {
  private val calendar: Calendar = Calendar.getInstance()

  override fun format(record: LogRecord): String {
    val sb = StringBuilder()
    calendar.timeInMillis = record.millis
    sb.append(StringColor.BLUE)
      .append(calendar[Calendar.MONTH] + 1).append("-").append(calendar[Calendar.DAY_OF_MONTH])
      .append("-").append(calendar[Calendar.HOUR_OF_DAY]).append("-")
      .append(calendar[Calendar.MINUTE]).append("-").append(calendar[Calendar.SECOND])
      .append(StringColor.GREEN).append("[").append(record.level.name).append("] ")
      .append(StringColor.RESET).append("|")
      .append(StringColor.RESET).append(record.message).append(StringColor.RESET).append("\n")
    return sb.toString()
  }
}
