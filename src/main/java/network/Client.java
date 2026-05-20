package network;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try(Socket socket= new Socket("LAPTOP-L60GQFEO",9090);
            Scanner scanner= new Scanner(System.in);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ) {

            int choice =0;
            Request request= null;
            while(true){
                System.out.println("==Menu");
                System.out.println("1. Find by company's id");
                System.out.println("2. List compaies");
                System.out.println("3. Count per job by company");
                choice = scanner.nextInt();

                switch (choice){
                    case 1->{
                        CommandType commandType= CommandType.COMPANY_FIND_BY_ID;
                        String companyId= "CP1";
                         request= Request.builder().commandType(commandType).data(companyId).build();
                    }
                    case 2 ->{
                        CommandType commandType= CommandType.COMPANY_LOAD_ALL;
                        request = Request.builder().commandType(commandType).data(null).build();

                    }
                    case 3->{
                        CommandType commandType= CommandType.COUNT_PER_JOB_BY_COMPANY;
                        String companyName="FinGroup";
                        request=Request.builder().commandType(commandType).data(companyName).build();
                    }
                }
                out.writeObject(request);
                out.flush();

                Response response= (Response) in.readObject();
                System.out.println(response);
            }

        }  catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
