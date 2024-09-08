# MyPaint
## An application based on the popular graphics editor MS Paint.
* [POLSKI](#dokładny-opis-zadania-po-polsku) 
* [ENGLISH](#detailed-description-of-the-task-in-English)

### Dokładny opis zadania po polsku:
Stworzyć prosty edytor graficzny zawierający menu rozwijalne (JMenu), pasek stanu (JToolBar) oraz obszar rysowania (JPanel).
#### Menu rozwijalne:
- **File**:
    - Open - za pomocą dialogu wyboru plików (JFileChooser) wczytuje plik do edytora (wyświetlając zapisane figury jednocześnie umożliwiając dalsze rysowanie/modyfikacje (zgodnie z działaniem edytora)),
    - Save - zapisuje aktualną zawartość edytora do bieżącego pliku (dialog wyboru plików będzie użyty jeśli pliku nie ma),
    - Save As... - zapisuje aktualną zawartość edytora do pliku wybranego za pomocą dialogu,
    - Quit - zakończenie działania edytora (po ewentualnym sprawdzaniu, czy należy zapisać zawartość edytora do pliku).

 
- **Draw**:
    - Figure
         - Circle - przy naciśnięciu przycisku myszy następuje wykreślenie (w obszarze rysowania) koła ze środkiem w miejscu kursora myszki, o stałym promieniu, w losowym kolorze,
         - Square - przy naciśnięciu przycisku myszy następuje wykreślenie (w obszarze rysowania) kwadratu ze środkiem w miejscu kursora myszki, o stałym boku, w losowym kolorze,
         - Pen - wykreślenie odręczne przy przeciąganiu kursora myszki (przytrzymujac nacisniety przycisk myszki).

    - Color - wybór koloru dla trybu Pen za pomocą JColorChooser.
    - Clear - wyczyszczenie całego obszaru rysowania.

Wszystkie opcje menu posiadają odpowiednie tzw. ***mnemoniki*** (zob. w dokumentacji metodę setMnemonic(...)) i ***akceleratory*** (zob. metodę setAccelerator(...)).

***Pasek stanu*** powinien zawierać informacje o aktualnym trybie rysowania (Circle, Square lub Pen) oraz stanie pliku (New, Modified lub Saved).

***Edytor*** powinien umożliwiać usunięcie figury/figur (koła, kwadratu) w momencie naciskania przycisku myszki w obrębie wybranej figury (lub figur) przy jednoczesnym wciśnięciu klawisza D (bez Shift). Użytkownik powinien mieć możliwość potwierdzenia swojej decyzji w pojawiającym się na ekranie dialogu.

***Tytuł okna*** powinien zawierać nazwę edytowanego pliku (lub "Simple Draw" - jeśli pliku nie ma).

<br />
<br />

### Detailed description of the task in English:
Create a simple graphic editor containing a dropdown menu (JMenu), a status bar (JToolBar), and a drawing area (JPanel).
#### Dropdown menu:
- **File**:
  - Open - uses a file chooser dialog (JFileChooser) to load a file into the editor, displaying saved shapes while allowing further drawing/modifications (according to the editor’s functionality).
  - Save - saves the current content of the editor to the existing file (a file chooser dialog will be used if the file does not exist).
  - Save As... - Saves the current content of the editor to a file chosen via a dialog.
  - Quit - exits the editor (after optionally checking if the editor’s content needs to be saved).
 
 - **Draw**:
   - Figure
     - Circle - when pressing the left mouse key, draws (in the drawing area) a circle with its center at the mouse cursor, with a fixed radius and in a random color.
     - Square - when pressing the left mouse key, draws (in the drawing area) a square with its center at the mouse cursor, with a fixed side length and in a random color.
     - Pen - allows freehand drawing by dragging the mouse cursor (while holding down the mouse button).
   - Color - selects the color for the Pen mode using JColorChooser.
   - Clear - clears the entire drawing area.
  
   All menu options should have appropriate ***mnemonics*** (see the setMnemonic(...) method in the documentation) and ***accelerators*** (see the setAccelerator(...) method in the documentation).

***The status bar*** should display information about the current drawing mode (Circle, Square, or Pen) and the file status (New, Modified, or Saved).

***The editor*** should allow the removal of shapes (circle, square) by clicking the mouse button within the selected shape(s) while holding down the D key (without Shift). The user should be able to confirm their decision in a dialog that appears on the screen.

***The window title*** should contain the name of the edited file (or "Simple Draw" if no file is open).
