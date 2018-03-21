import java.util.ArrayList;
import java.util.Scanner;

class Room 
{
    private String roomID  = null;
    private boolean booked = false;

    Room(String roomID)
    {
        this.roomID = roomID;
    }

    String getRoomID()
    {
        return roomID;
    }

    void cancel()
    {                          
        booked = false;    }                                                                          14                                                                                                   


    boolean isBooked()
    {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }


}

class RoomDB 
{
    private ArrayList<Room> room;
    private String[] roomID = {"Room1","Room2","Room3","Room4","A/c Room1","A/cRoom2","Deluxe Room1","Deluxe Room2","VIPRoom1","VIPRoom2"};

    RoomDB(){

        room = new ArrayList<Room>();                     
        for(int i=0;i<roomID.length;i++)
        {
            addRoom(new Room(roomID[i]));
        }

    }

    public void addRoom(Room addRoom){                                               
        room.add(addRoom);
    }

    public ArrayList<Room> getRoom(){
        return room;
    }
}

public class Boking {

    static RoomDB roomDB = new RoomDB();

    public static void main(String[] args) {
        String roomID;      
        Room room; 
        Room room1;
        Room room2;
        Scanner inputID = new Scanner(System.in);

        while(true){

            System.out.println("Please choose the room you want to book \n"+getRoomList(roomDB));

            while(true){
                System.out.println("Enter your Room no. : (Enter x for quite ) : ");
                roomID = inputID.nextLine();
                System.out.println("X : " + roomID.equals("x"));
                if(roomID.equals("x")){
                    System.out.println("Break");
                    break;
                }                                                                                               16

                if(getRoom(roomID) == null){

                    System.out.println("The room ID is incorrect, please enter again or enter x to quit");


                }
                else{
                   room= getRoom(roomID); 

                 room1= getRoom(roomID);
                   room2= getRoom(roomID);                      
                       Meenu m=new Meenu(room,room1,room2);

                  

                }
             }


            }

        }

    

    public static String getRoomList(RoomDB roomDB)
    {

        String roomList = "";
        for(Room r:roomDB.getRoom())                                                       17
        {

            if(!r.isBooked())
            {
                roomList = roomList+r.getRoomID()+" is free"+"   ";
            }
            else
            {
                roomList = roomList+r.getRoomID()+" has been booked ";
            }

        }
        return roomList;
    }


    public static Room getRoom(String roomID){

        for(Room r:roomDB.getRoom()){

            if(r.getRoomID().equals(roomID)){
                System.out.println("r.getRoomID : " + r.getRoomID() + "  AND user.roomID :" + roomID);
                return r;
            }

        }
        return null;

    }

}                                                                                                            18
class Meenu extends Boking
{

Meenu(Room c,Room d,Room e){
String b;

System.out.println("1.book ticket in mumbai");
System.out.println("2.cancel ticket in mumbai ");
System.out.println("3.book ticket in delhi");
System.out.println("4.cancel in delhi");
System.out.println("5.book ticket in hyderabad");
System.out.println("6.cancel in hyderabad");
System.out.println("enter u r option");
Scanner a=new Scanner(System.in);
b=a.nextLine();
switch(b)
{
case "1":

                    if(!c.isBooked()){
                        System.out.println("Book successfully");
                        c.setBooked(true);
}
 else{
                        System.out.println("please enter the room ID again or enter x to quit");
                    }

    
                        
                   
break;                                                                                                   19
case "2":
c.cancel();
System.out.println("canceled sucessfully");
break;
case "3":
if(!d.isBooked()){
                        System.out.println("Book successfully");
                        d.setBooked(true);
}
 else{
                        System.out.println("please enter the room ID again or enter x to quit");
                    }

    
break;

case "4":
d.cancel();
System.out.println(" canceled succesfully");
break;
case "5":if(!e.isBooked()){
                        System.out.println("Book successfully");
                        e.setBooked(true);
}
 else{
                        System.out.println("please enter the room ID again or enter x to quit");
                    }

break;
case "6":                                                                                                  20
e.cancel();  
System.out.println("canceled succesfully");  
break;
}
}
}

