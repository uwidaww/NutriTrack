import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "NutriTrack.db"
        private const val DATABASE_VERSION = 1

        // Table for User
        const val TABLE_USER = "User"
        const val COLUMN_USER_ID = "id"
        const val COLUMN_USER_NAME = "name"
        const val COLUMN_USER_EMAIL = "email"
        const val COLUMN_USER_PASSWORD = "password"

        // Table for Questionnaire
        const val TABLE_QUESTIONNAIRE = "Questionnaire"
        const val COLUMN_QUESTION_ID = "id"
        const val COLUMN_USER_ID_FK = "user_id"
        const val COLUMN_ANSWER_ONE = "answer_one"
        const val COLUMN_ANSWER_TWO = "answer_two"
        const val COLUMN_ANSWER_THREE = "answer_three"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createUserTable = """
            CREATE TABLE $TABLE_USER (
                $COLUMN_USER_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_USER_NAME TEXT,
                $COLUMN_USER_EMAIL TEXT,
                $COLUMN_USER_PASSWORD TEXT
            )
        """
        db?.execSQL(createUserTable)

        val createQuestionnaireTable = """
            CREATE TABLE $TABLE_QUESTIONNAIRE (
                $COLUMN_QUESTION_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_USER_ID_FK INTEGER,
                $COLUMN_ANSWER_ONE TEXT,
                $COLUMN_ANSWER_TWO TEXT,
                $COLUMN_ANSWER_THREE TEXT,
                FOREIGN KEY($COLUMN_USER_ID_FK) REFERENCES $TABLE_USER($COLUMN_USER_ID)
            )
        """
        db?.execSQL(createQuestionnaireTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_USER")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_QUESTIONNAIRE")
        onCreate(db)
    }
}
