package algomaster.designpatterns.iterator;

public class Client {
    public static void main(String[] args) {

        Playlist playlist = new Playlist();

        playlist.addSong("Shape of you");
        playlist.addSong("Outside");
        playlist.addSong("Beauty and a beast");

        Iterator<String> iterator = playlist.createForwardIterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        Iterator<String> reverseIterator = playlist.createReverseIterator();

        while(reverseIterator.hasNext()){
            System.out.println(reverseIterator.next());
        }

    }
}
