package fi.lleevi.urbanminigolf.io;

import fi.lleevi.urbanminigolf.game.objects.GameMap;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Karttatiedostonlukija.
 * @author lleevi
 */
public class FileReader {

    /**
     * Lukee tiedoton ja muodostaa niistä listan karttoja.
     * 
     * @return lista luetuista kartoista
     */
    public static List<GameMap> loadGameMaps() {
        ArrayList<GameMap> maps = new ArrayList<>();
        try {
            File mapFile = new File("defaultmap.urbanmap");
            Scanner reader = new Scanner(mapFile);
            String unParsedMap = "";
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (line.contains("/BEGIN")) {
                    unParsedMap = "";
                } else if (line.contains("/END")) {
                    maps.add(new GameMap(unParsedMap));
                } else {
                    unParsedMap += line;
                }
            }

            return maps;
        } catch (Exception e) {
            System.out.println("Unable to load map file");
        }
        return maps;
    }

}
