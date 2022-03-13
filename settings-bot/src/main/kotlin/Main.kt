import com.pengrad.telegrambot.TelegramBot
import com.pengrad.telegrambot.UpdatesListener
import com.pengrad.telegrambot.request.SendMessage


fun main(args: Array<String>) {
    val tgBot = TelegramBot(System.getenv("BOT_TOKEN"))

    tgBot.setUpdatesListener { updates ->
        updates.forEach {
            val chatId = it.message().chat().id()
            val responseMessage = SendMessage(chatId, "Hello!")
            tgBot.execute(responseMessage)
        }
        UpdatesListener.CONFIRMED_UPDATES_ALL
    }
}