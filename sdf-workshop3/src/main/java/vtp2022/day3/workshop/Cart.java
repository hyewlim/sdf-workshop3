package vtp2022.day3.workshop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

public class Cart {
    private List<String> contents = new LinkedList<>();
    private String username;

    public Cart(String name){
        this.username = name;
    }

    public String getUsername(){
        return username;
    }

    public void add(String item){
        for(String inCart: contents)
            if(inCart.equals(item))
                return;
        contents.add(item);
    }

    public String delete(int index){
        if (index < contents.size()){
            return contents.remove(index);
            
        } return "nothing";
    }

    
    public void load(InputStream is) throws IOException {
        InputStreamReader isr = new InputStreamReader(is); //used to read characters from files (or network connections) where the bytes represents text.
        BufferedReader br = new BufferedReader (isr); //simplifies reading text from a character input stream. It buffers the characters in order to enable efficient reading of text data.
        String item;
        while ((item = br.readLine()) != null)
            contents.add(item);
        br.close(); //close br before isr, last in first out
        isr.close();
    }

    public void save(OutputStream os) throws IOException{
        OutputStreamWriter ows = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(ows);
        for(String item: contents)
            bw.write(item + "\n");
        
        osw.flush();
        bw.flush();
        osw.close();
        bw.close(); //output no need for last in first out, no need sequence because it has flushed.
    }

    public List<String> getContents(){

    }
}
