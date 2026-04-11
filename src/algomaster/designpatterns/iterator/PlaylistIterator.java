package algomaster.designpatterns.iterator;

public class PlaylistIterator implements Iterator<String>{

    private Playlist playlist;
    private int index = 0;

    public PlaylistIterator(Playlist playlist) {
        this.playlist = playlist;
    }

    @Override
    public boolean hasNext() {
        return index < this.playlist.getSize();
    }

    @Override
    public String next() {
        if(!hasNext()) throw new IllegalStateException("There is no next element available.");
        return this.playlist.getSongAt(index++);
    }
    
}
