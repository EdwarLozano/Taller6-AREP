package co.edu.eci.arep.logroundrobin;

import java.io.IOException;

import static spark.Spark.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Logroundrobin {
    public static void main(String[] args) {
        port(getPort());
        staticFiles.location("/public");
        get("/log", (req, pesp) -> {
            String val = req.queryParams("value");
            return logMessage(val);
        });

    }
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    private static String logMessage(String val) throws IOException {

        return HttpRemoteCaller.remoteLogCall(val);
    }


}
