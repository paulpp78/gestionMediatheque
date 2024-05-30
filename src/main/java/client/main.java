package client;

import server.db.MediathequeDbService;
import server.db.data.ManageDataStorage;
import server.db.model.AbonneModel;
import server.db.model.DocumentModel;
import server.elements.Abonne;
import server.elements.Documents.Document;
import server.environment.Environment;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class main {
    public static void main(String[] args) throws IOException {

//        if (args.length != 1) {
//            System.err.println("Services disponible : " + SelectionPortServer.getServices());
//            return;
//        }

        //Voir avec le prof pour savoir on passe en parametre et si pas de param on fait quoi

        SelectionPortServer.messageBienvenueWithtoutServices();

        ClientServer client;
        try {
            client = new ClientServer(SelectionPortServer.getPort(args[0]));
            System.out.println(client.getBttpProtocole().getResponseServer());

            //A voir vu que ducoup on recuperer pas les reponses du serveur
//            while (true) {
////                client.getBttpProtocole().initInOut();
//                System.out.println(client.getBttpProtocole().getResponseServer());
//
//                String line = client.getClavierInput().readLine();
//
//                if (line.toLowerCase() == "exit") {
//                    break;
//                }
//
//                System.out.println(client.getBttpProtocole().communicate(line));
//            }

            System.out.println(client.getBttpProtocole().getResponseServer());
            System.out.println(client.getBttpProtocole().getResponseServer());
            client.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
