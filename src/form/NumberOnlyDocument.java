package form;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

//Custom Document for number only input
class NumberOnlyDocument extends PlainDocument {

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if (str == null) {
            return;
        }
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return; // Ignore non-numeric input
        }
        super.insertString(offs, str, a);
    }  
}
