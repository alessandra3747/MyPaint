package Enumeracje;

public enum FileState {
    NEW, MODIFIED, SAVED ;

    public static FileState currentFileState = FileState.NEW;

}
