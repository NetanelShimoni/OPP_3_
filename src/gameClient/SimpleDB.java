package gameClient;

//import com.sun.java.util.jar.pack.Instruction;

import org.omg.CORBA.INTERNAL;
import org.omg.PortableInterceptor.INACTIVE;
import utils.StdDraw;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 * This class represents a simple example of using MySQL Data-Base.
 * Use this example for writing solution.
 *
 * @author boaz.benmoshe
 */
public class SimpleDB {
    public static final String jdbcUrl = "jdbc:mysql://db-mysql-ams3-67328-do-user-4468260-0.db.ondigitalocean.com:25060/oop?useUnicode=yes&characterEncoding=UTF-8&useSSL=false";
    public static final String jdbcUser = "student";
    public static final String jdbcUserPassword = "OOP2020student";
    public static StdDraw st = new StdDraw();
	public static HashMap<Integer, Integer> allans= new HashMap<Integer, Integer>();
	public static HashMap <Integer, HashMap<Integer,Integer>> allscorealllevel= new HashMap<Integer,  HashMap<Integer,Integer>>();

	/**
     * Simple main for demonstrating the use of the Data-base
     *
     * @param args
     */
    public static void main(String[] args) {
        int id1 = MyGameGUI.id_integer;  // "dummy existing ID
        int level = 0;
        //printLog();
        //allUsers();
        printLog();
        String kml = getKML(id1, MyGameGUI.num_game);
        System.out.println("***** KML file example: ******");
        System.out.println(kml);
    }

    /**
     * simply prints all the games as played by the users (in the database).
     */
    static int howManyGame = 0, Level = 0, value = 0, placeInClass = 0, MaxMove = 0;
    static String s="";
    public static int level;
    public static void printLog() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection =
                    DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcUserPassword);
            Statement statement = connection.createStatement();
            String allCustomersQuery = "SELECT * FROM Logs;";
            ResultSet resultSet = statement.executeQuery(allCustomersQuery);
            switch (MyGameGUI.num_game) {
                case 0: {
                    MaxMove = 290;
                    break;
                }
				case 1: {
					MaxMove=580;
					break;
				}
				case 3: {
					MaxMove=580;
					break;
				}
				case 5: {
					MaxMove=500;
					break;
				}
				case 9: {
					MaxMove=580;
					break;
				}
				case 11: {
					MaxMove=580;
					break;
				}
				case 13: {
					MaxMove=580;
					break;
				}
				case 16: {
					MaxMove=290;
					break;
				}
				case 19: {
					MaxMove=580;
					break;
				}
				case 20: {
					MaxMove=290;
					break;
				}
				case 23: {
					MaxMove=1140;
					break;
				}

            }
            while (resultSet.next()) {
                int id = resultSet.getInt("UserID");
                int score = resultSet.getInt("score");
                level= resultSet.getInt("levelID");
                if (id == MyGameGUI.id_integer) {
                    if (allscorealllevel.get(id)==null ){
                        allscorealllevel.put(id,new HashMap<Integer, Integer>());
                        allscorealllevel.get(id).put(level,score);
                    }else{
                        if(allscorealllevel.get(id).get(level)!=null) {
                            if (allscorealllevel.get(id).get(level) < score) {
                                allscorealllevel.get(id).remove(level);
                                allscorealllevel.get(id).put(level, score);
                            }
                        }
                    }


                }

                    if (MyGameGUI.num_game == level) {
                    //System.out.println("Id: " + resultSet.getInt("UserID")+","+resultSet.getInt("levelID")+","+resultSet.getInt("moves")+","+resultSet.getDate("time")+", "+resultSet.getInt("score"));
                   // int id = resultSet.getInt("UserID");
                  //  System.out.println("this is id :"+id);
                    if (id == MyGameGUI.id_integer) {
                       // System.out.println("i am herer!!!!!!");
                        howManyGame++;
                        //System.out.println("Id: " + resultSet.getInt("UserID") + ", Level: " + resultSet.getInt("levelID") + ",Move: " + resultSet.getInt("moves") + ",Time: " + resultSet.getDate("time") + ",Score: " + resultSet.getInt("score"));
                        Level = resultSet.getInt("levelID");
                        if (score > value) {
                            value = score;
                        }


                    }
                }

            }

            Class.forName("com.mysql.jdbc.Driver");
            connection =
                    DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcUserPassword);
            statement = connection.createStatement();
            allCustomersQuery = "SELECT * FROM Logs;";
            resultSet = statement.executeQuery(allCustomersQuery);
            while (resultSet.next()) {
                int score = resultSet.getInt("score");
                int moves = resultSet.getInt("moves");
                int id = resultSet.getInt("UserID");
                int levelID = resultSet.getInt("levelID");

                //System.out.println("score of all class: " + score + " this is your moves: " + moves);
//                if (MyGameGUI.count <= MaxMove) {
                    if (MyGameGUI.gradeofgame < score && moves <= MaxMove && levelID == MyGameGUI.num_game) {
                        if (allans.get(id) == null || allans.get(id)<score) {
                            allans.remove(id,allans.get(id));
                            allans.put(id, score);
                            placeInClass++;
                            System.out.println("Id: " + resultSet.getInt("UserID") + ", Level: " + resultSet.getInt("levelID") + ",Move: " + resultSet.getInt("moves") + ",Time: "
                                    + resultSet.getDate("time") + ",Score: " + resultSet.getInt("score"));
                        }

                    }

                }
            /*}*/
            /*StdDraw.setCanvasSize(2000,800);
            StdDraw.setXscale(-50,50);
            StdDraw.setYscale(-50,50);*/
            for (int i = 0; i <allscorealllevel.size() ; i++) {
                s+="In level: "+ allscorealllevel.get(MyGameGUI.id_integer) +"Your best score is: "+ allscorealllevel.get(MyGameGUI.id_integer).get(level) +"\n";

            }
            System.out.println(s);
            StdDraw.text(150,120,"we place on class: " + placeInClass,3);
                                                                                                                                     //  s="level: 0 score: 147\n" + "level: 1 score: 441\n" + "level: 3 score: 723\n" + "level: 5 score: 592\n" + "level: 9 score: 483\n" + "level: 11 score: 1073\n" + "level: 13 score: 323\n" + "level: 16 score: 243\n" + "level: 19 score: 254\n" + "level: 20 score: 203\n" + "level: 23 score: 1011\n";

            //Object game_select = JOptionPane.showInputDialog(null, "Choose a mood", "Note", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("robot_tec.jpg"), p, p[0]);
            JOptionPane.showMessageDialog(null, "Current game: " + Level + "\n Your grade is: "+MyGameGUI.gradeofgame+       "\n Place on class: " +
                    "" + placeInClass+
                    "\n High value of this game: " +
                    "" + value + "\n Num of game we play (this game): " + howManyGame);
//            JOptionPane.showMessageDialog(null,"your score in game 0 is:\n");
            System.err.println("\n We place on class: " + placeInClass);

                System.err.println("high value of this game " + value);
                System.err.println("num of game we play: " + howManyGame);

                //MyGameGUI.t1.join();

			System.out.println("*********KML IS************");
			String kml=getKML(MyGameGUI.id_integer,MyGameGUI.num_game);
			System.out.println(kml);
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            System.out.println("Vendor Error: " + sqle.getErrorCode());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * this function returns the KML string as stored in the database (userID, level);
     *
     * @param id
     * @param level
     * @return
     */
    public static String getKML(int id, int level) {
        String ans = null;
        String allCustomersQuery = "SELECT * FROM Users where userID=" + id + ";";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection =
                    DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcUserPassword);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(allCustomersQuery);
            if (resultSet != null && resultSet.next()) {
                ans = resultSet.getString("kml_" + level);
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            System.out.println("Vendor Error: " + sqle.getErrorCode());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ans;
    }

    public static int allUsers() {
        int ans = 0;
        String allCustomersQuery = "SELECT * FROM Users;";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection =
                    DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcUserPassword);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(allCustomersQuery);
            while (resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt("UserID"));
                ans++;
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            System.out.println("Vendor Error: " + sqle.getErrorCode());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ans;
    }
}
		
