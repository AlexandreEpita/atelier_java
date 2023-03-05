package fr.epita.assistants.travel;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

public class Country {
    public String countryName;
    public ZoneId countryZone;
    public Map<String,Integer> travelTimes;

    public Country(String countryName, String countryZone, String inputFilePath) {
        this.countryName = countryName;
        this.countryZone = ZoneId.of(countryZone);
        this.travelTimes = initTravelTimes(inputFilePath);
    }

    public Map<String, Integer> initTravelTimes(String inputFilePath) {

        this.travelTimes = new HashMap<>();
        try {
            FileReader filereader = new FileReader(inputFilePath);
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;
            boolean begin = true;

            while ((nextRecord = csvReader.readNext()) != null) {
                if (begin) {
                    begin = false;
                    continue;
                }

                String target1 = null;
                String target2 = null;
                int time = 0;
                int i = 0;
                for (String cell : nextRecord) {
                    if (i == 0)
                    {
                        target1 = new String(cell);
                        i++;
                        continue;
                    }
                    if (i == 1)
                    {
                        target2 = new String(cell);
                        i++;
                    }
                    else
                        time = Integer.parseInt(cell);

                }
                if (target1.equals(this.countryName))
                {
                    this.travelTimes.put(target2, time);
                }
                else if (target2.equals(this.countryName))
                {
                    this.travelTimes.put(target1,time);
                }
            }
        } catch (Exception e) {
            return null;
        }
        return this.travelTimes;
    }

}
