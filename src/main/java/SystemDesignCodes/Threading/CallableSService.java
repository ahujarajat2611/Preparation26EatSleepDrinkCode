package SystemDesignCodes.Threading;

/**
 * Created by hadoop on 18/12/17.
 */
public class CallableSService {

}
/*
    ExecutorService pool = Executors.newFixedThreadPool(10);
    List<Callable<String>> tasks = new ArrayList<>();
    tasks.add(new Callable<String>() {
        public String call() throws Exception {
            Thread.sleep((new Random().nextInt(5000)) + 500);
            return "Hello world";
        }

    });
    List<Future<String>> results = pool.invokeAll(tasks);

    for (Future<String> future : results) {
        System.out.println(future.get());
    }
    pool.shutdown();


 */
/*



ExecutorService pool = Executors.newFixedThreadPool(10);

    List<Callable<List<StudentsResults>>> stasks = new ArrayList<>();
    List<Callable<List<DoctorsResults>>> dtasks = new ArrayList<>();
    List<Callable<List<PatientsResults>>> ptasks = new ArrayList<>();

    stasks.add(new Callable<List<StudentsResults>>() {
        public List<StudentsResults> call() throws Exception {
            return retrieveStdWS1();
        }

    });
    stasks.add(new Callable<List<StudentsResults>>() {
        public List<StudentsResults> call() throws Exception {
            return retrieveStdWS2();
        }

    });
    stasks.add(new Callable<List<StudentsResults>>() {
        public List<StudentsResults> call() throws Exception {
            return retrieveStdWS3();
        }

    });

    dtasks.add(new Callable<List<DoctorsResults>>() {
        public List<DoctorsResults> call() throws Exception {
            return retrieveDocWS4();
        }

    });
    dtasks.add(new Callable<List<DoctorsResults>>() {
    public List<DoctorsResults> call() throws Exception {
            return retrieveDocWS5();
        }

    });
    dtasks.add(new Callable<List<DoctorsResults>>() {
        public List<DoctorsResults> call() throws Exception {
            return retrieveDocWS6();
        }

    });

    ptasks.add(new Callable<List<PatientsResults>>() {
        public List<PatientsResults> call() throws Exception {
            return retrievePtWS7();
        }

    });
    ptasks.add(new Callable<List<PatientsResults>>() {
        public List<PatientsResults> call() throws Exception {
            return retrievePtWS8();
        }

    });
    ptasks.add(new Callable<List<PatientsResults>>() {
        public List<PatientsResults> call() throws Exception {
            return retrievePtWS9();
        }

    });

    List<Future<List<StudentsResults>>> sresults = pool.invokeAll(stasks);
    List<Future<List<DoctorsResults>>> dresults = pool.invokeAll(dtasks);
    List<Future<List<PatientsResults>>> presults = pool.invokeAll(ptasks);

    for (Future<List<StudentsResults>> future : sresults) {
       this.studentsResults.addAll(future.get());
    }
    for (Future<List<DoctorsResults>> future : dresults) {
       this.doctorsResults.addAll(future.get());
    }
    for (Future<List<PatientsResults>> future : presults) {
       this.patientsResults.addAll(future.get());
    }
    pool.shutdown();
 */