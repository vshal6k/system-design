package algomaster.designpatterns.iterator;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private List<String> songs = new ArrayList<>();
    
    public void addSong(String song){
        this.songs.add(song);
    }

    public String getSongAt(int index){
        if(index < 0 && index > this.songs.size()) throw new IllegalArgumentException("Provide a valid index.");
        return this.songs.get(index);
    }
    
    public int getSize(){
        return this.songs.size();
    }

    public Iterator<String> createForwardIterator() {
        return new PlaylistIterator(this);
    }

    public Iterator<String> createReverseIterator() {
        return new ReversePlaylistIterator(this);
    }
}
