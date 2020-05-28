package pl.kowalecki.zad5;

public class Task {


    private String subjectName;
    private String subjectToDo;

    public static final Task[] tasks = {
            new Task("Lab 5", "5. Fragmenty\n" +
                    "- bazuje na rozdziałach nr 7-8 (9-11 w drugiej edycji);\n\n" +
                    "-aplikacja powinna dotyczyć programowania (o ile ktoś nie kontynuuje apek z poprzednich laborek),\n\n" +
                    "-utwórz aktywność, która będzie korzystać z z co najmniej dwóch fragmentów,\n\n" +
                    "-pamiętaj o layoutach fragmentu, klasie Fragment, metodzie onCreateView() w plikach .java,\n\n" +
                    "-fragmenty mogą pobierać dane z pliku -.java lub z bazy danych,\n\n" +
                    "-pamiętaj o obiekcie klasy LayoutInflater - przygotowanie układu (ang. inflate) oznacza przekształcenie widoków określonych w kodzie XML układu na obiekty Javy,\n\n" +
                    "-skorzystaj z menedżera fragmentów, np. getFragmentManager(), w celu pobrania referencji do fragmentu,\n\n" +
                    "-wykorzystaj interfejs do komunkacji aktywności z fragmentem,\n\n" +
                    "-wykorzystaj transakcję fragmentu;\n\n" +
                    "-utwórz fragment zagnieżdżony w innym fragmencie,\n\n" +
                    "-pamiętaj o zagnieżdżonych transakcjach,\n\n" +
                    "-wykorzystaj interfejs OnClickListener do obsługi kliknięć."),
            new Task("Lab 6", "6. Baza danych SQLite i kursory\n\n-bazuje na rozdziale nr 11 i 12 (15 i 16 w drugiej edycji);\n\n" +
                    "-należy rozwinąć lub zmodyfikować apki z innych zadań, tak by dane pobierane były z bazy danych zamiast z plików;\n\n" +
                    "-należy utworzyć bazę danych SQLite do przechowywania ww. danych;\n\n" +
                    "-skorzystaj z klasy SQLiteOpenHelper() do tworzenia i utrzymania ww. bazy,\n\n" +
                    "-pamiętaj o metodach onCreate() i onUpgrade(), ewentualnie onDowngrade(),\n\n" +
                    "-skorzystaj z obiektu typu Cursor() i metody query() do tworzenia zapytań,\n\n" +
                    "-wykorzystaj co najmniej dwa różne zapytania w aplikacji,\n\n" +
                    "-skorzystaj z wybranych metod poruszania się po kursorze: moveToFirst(), moveToLast(), moveToPrevious(), moveToNext()."),
            new Task("Lab 7", "7. Zadania asynchroniczne\n\n -bazuje na rozdziale nr 12 (17 w drugiej edycji);\n\n" +
                    "-przeanalizuj rodzaje wątków w aplikacjach na Androida,\n\n" +
                    "-wykorzystaj klasę AsyncTask do obsługi kodu, korzystającego z bazy danych, umieszczając go w osobnym wątku,\n\n" +
                    "-zaimplementuj metody onPreExecute(), doInBackground(), onPostExecute() oraz onProgressUpdate(),\n\n" +
                    "-pamiętaj o parametrach Params, Progress oraz Results klasy AsyncTask,\n\n" +
                    "-spróbuj oszacować różnicę czasów dla apki bez klasy AsyncTask i z użyciem tej klasy klasą. Skorzystaj np. z klasy TimingLogger."),
            new Task("Lab 8", "8. Usługi uruchomione i usługi powiązane\n\n -bazuje na rozdziale nr 13 (nr 18 i 19 w drugiej edycji);\n\n" +
                    "-part I:\n" +
                    "-utwórz usługę uruchomioną korzystając z klasy IntentService, do innego celu niż w książce;\n\n" +
                    "-usługa powinna być uruchamiana po kliknięciu przycisku w aktywności,\n\n" +
                    "-pamiętaj o metodach onHandleIntent() i startService(),\n\n" +
                    "-użyj usługi np. do wyświetlenia wybranego tekstu najpierw w dzienniku zdarzeń, a w drugim kroku jako powiadomienie lub do wybranego przez siebie zadania,\n\n" +
                    "-skorzystaj z obiektu typu NotificationManager,\n\n" +
                    "-part II:\n" +
                    "-utwórz usługę powiązaną, służącą do pomiaru odległości,\n\n" +
                    "-wykorzystaj systemową usługę lokalizacyjną,\n\n" +
                    "-utwórz aktywność, która będzie komunikować się z ww. usługą,\n\n" +
                    "-wykorystaj obiekt typu Binder do powiązania aktywności z usługą. Usługa powiązana tworzy obiekt Binder, zawiera on zawiera referencję do usługi powiązanej.\n\n" +
                    "-wykorzystaj obiekt typu ServiceConnection. Aktywność tworzy obiekt ServiceConnection, służy on do utworzenia połączenia z usługą.\n\n" +
                    "-zaimplementuj interfejs LocationListener i zarejestruj obiekt tego typu w systemowej usłudze lokalizacyjnej,\n\n" +
                    "-w momencie tworzenia usługi należy przygotować obiekt nasłuchujący, który będzie odbierać informacje o zmianach lokalizacji urządzenia\n\n" +
                    "-utwórz metodę do pomiaru odległości korzystając z metody onLocationChanged(Location() obiektu typu LocationListener,\n\n" +
                    "-pamiętaj o metodzie bindService(), aby powiązać aktywność z usługą,\n\n" +
                    "-pamiętaj o modyfikacji pliku manifestu, w celu uzyskania uprawnień do korzystania z odbiornika GPS,")
    };

    public Task(String subjectName, String subjectToDo) {
        this.subjectName = subjectName;
        this.subjectToDo = subjectToDo;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectToDo() {
        return subjectToDo;
    }

    public void setSubjectToDo(String subjectToDo) {
        this.subjectToDo = subjectToDo;
    }

    @Override
    public String toString() {
        return this.subjectName;
    }
}
