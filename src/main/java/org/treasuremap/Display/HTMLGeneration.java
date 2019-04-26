package org.treasuremap.Display;

import org.treasuremap.Player.Player;
import org.treasuremap.board.Map;
import org.treasuremap.board.Tile;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HTMLGeneration {
    /**
     * Constructor requiring below paramters to create a generator of html files, these files will output the maps of
     * players per round, their respective player's point of view.
     * @param players - array of players,
     * @param playerNo - current (iteration) player that is handled
     * @param map - the tile map that is used
     * @param turnNo - current turn number of the game
     */
    public HTMLGeneration(
            Player[] players, int playerNo, Map map, int turnNo){
        try {
            generateHTMLPlayerFile(players, playerNo, map, turnNo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method that generates the map of the player file in HTML format.
     * @param players - array of players
     * @param playerNo - current player being handled
     * @param map - map of the game
     * @param turnNo - current round of the game
     * @return the outputted html file
     * @throws IOException
     */
    public File generateHTMLPlayerFile(
            Player[] players, int playerNo, Map map, int turnNo) throws IOException {
        String file = "map_player_" + (playerNo+1) + ".html";

        File htmlFile = new File(file);
        BufferedWriter bw = new BufferedWriter(new FileWriter(htmlFile));

        writeHTMLFile(bw, players, playerNo, map, turnNo);
        return htmlFile;
    }

    /**
     * This method opens on browser a page that outputs the html file
     * @param htmlFIle file to output on the browser
     * @throws IOException
     */
    public void displayFile(File htmlFIle)throws IOException{
        Desktop.getDesktop().browse(htmlFIle.toURI());
    }

    /**
     * This method writes the HTML code inside of the blank file
     * @param bw the buffer writer is used to actually write into the file
     * @param players array of different players playing the game
     * @param playerNo current player
     * @param map map of the game
     * @param turnNo current round number of game
     */
    private void writeHTMLFile(
            BufferedWriter bw, Player[] players, int playerNo, Map map, int turnNo) {
        int rows,cols;
        int mapSize = map.getSize();
        int tileSize = 25;
        int borderSize = 3;
        String tileColour = "";
        String player = "";
        try {
            bw.write("<!DOCTYPE html>");
            bw.write("<html>");
            bw.write("<head>");
            bw.write("<meta name='viewport' content='width=device-width, initial-scale=1'>");
            bw.write("<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css'");
            bw.write("integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' ");
            bw.write("crossorigin='anonymous'>");
            bw.write("<style>");
            bw.write("table {");
            bw.write("    border-collapse: collapse;");
            bw.write("}");
            bw.write("td, tr{");
            bw.write("    border: " + borderSize + "px solid black;");
            bw.write("    border-collapse: collapse;");
            bw.write("    height: "+ tileSize+ "px;");
            bw.write("    width: "+ tileSize + "px;");
            bw.write("    text-align : center;");
            bw.write("}");
            bw.write("</style>");
            bw.write("</head>");
            bw.write("<body>");
            bw.write("<h2>Player #"+(playerNo+1)+" Map:"+" Turn #"+turnNo+"</h2>");
            bw.write("<table>");
            for(rows = 0; rows < mapSize; rows ++){
                bw.write("<tr>");
                for(cols = 0; cols < mapSize; cols ++){
                    tileColour = getTileColour(rows,cols,map,players[playerNo].getTilesVisited());
                    player = isPlayerOnTile(players,playerNo,rows,cols);
                    bw.write("<td "+tileColour+">"+player+"</td>");
                }
                bw.write("</tr>");
            }
            bw.write("</table>");
            bw.write("</body>");
            bw.write("</html>");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to retrieve the HTML code that depicts the tile colour gathered by finding the tile on the
     * map and checking if the tiles has been unconvered or not.
     * @param rows - row number of tile
     * @param cols - column number of tile
     * @param map - mao of the game
     * @param tilesVisited - 2d array boolean corresponding with which tiles have been uncovered.
     * @return (String) colour - the HTML code conveying the tile colour
     */
    public String getTileColour(int rows, int cols, Map map, boolean[][] tilesVisited) {
        Tile tileColour;
        if(tilesVisited[rows][cols]) {
            tileColour = map.getTileType(rows, cols);
            switch (tileColour){
                case GRASS: return "bgcolor = #00FF00";
                case WATER: return "bgcolor = #00FFFF";
                case TREASURE: return "bgcolor = #FFFF00";
                default: return "";
            }
        } else {
            return "bgcolor = #C4C4C4";
        }
    }

    /**
     * Method which gives the player icon if that specific player is found on the tile
     * @param players array of Players
     * @param playerNum current player
     * @param rows row number of tile
     * @param cols column number of tile
     * @return icon of player or nothing
     */
    public String isPlayerOnTile(Player[]players, int playerNum, int rows, int cols){
        if(rows == players[playerNum].getPosition().getX() && cols == players[playerNum].getPosition().getY()){
            return "<i class='fas fa-male' style='font-size:24px'></i>";
        }
        return "";
    }
}
