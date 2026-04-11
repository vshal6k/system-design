package algomaster.designpatterns.iterator;

public class ReversePlaylistIterator implements Iterator<String>{

    private int index;
    private Playlist playlist;

    public ReversePlaylistIterator(Playlist playlist){
        this.playlist = playlist;
        index = playlist.getSize() - 1;
    }

    @Override
    public boolean hasNext() {
        return this.index >= 0;
    }

    @Override
    public String next() {
        if(!hasNext()) throw new IllegalStateException("There is no next element available.");
        return this.playlist.getSongAt(index--);
    }
    
}
