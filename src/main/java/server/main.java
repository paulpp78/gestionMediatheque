package server;

import config.Config;
import server.Operations.Emprunt.empruntServer;
import server.Operations.Reservation.reservationServer;
import server.Operations.Retour.retourServer;
import server.db.MediathequeDbService;
import server.db.data.DataFactory;
import server.db.model.AbonneModel;
import server.db.model.DVDModel;
import server.db.model.DocumentModel;
import server.db.model.Model;
import server.environment.Environment;
import server.serv.MediathequeServer;
import server.serv.MediathequeServerFactory;

import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) {
        Config.loadConfig();

        List<Class<? extends MediathequeServer>> serverClasses = Arrays.asList(
                empruntServer.class,
                reservationServer.class,
                retourServer.class
        );

        List<Class<? extends Model>> dataClasses = Arrays.asList(
                AbonneModel.class,
                DocumentModel.class,
                DVDModel.class
        );
        try {
            MediathequeDbService.setJdbcUrlClassDriver(Environment.URL, Environment.DRIVER);
            DataFactory.createDataInAppToDb(dataClasses);
            MediathequeServerFactory.createMediathequeServer(serverClasses);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
