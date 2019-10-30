package kata4.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kata4.model.Mail;

public class MailListReader {
    
    
    public static List<Mail> read(String FileName) {
        List<Mail> list = new ArrayList<>();
        
        try{
            BufferedReader reader = new BufferedReader(new FileReader(new File(FileName)));
            while(true){
                String line = reader.readLine();
                if(line == null)
                    break;
                if(Mail.isMail(line))
                    list.add(new Mail(line));
            }
        }
        catch(FileNotFoundException exception){
            System.out.println("ERROR MailListReader::read (FIle Not Found) " + exception.getMessage());
        }
        catch (IOException exception){
            System.out.println("ERROR MailListReader::read (FIle Not Found) " + exception.getMessage());
        }
            
        return list;
    }
    
}
