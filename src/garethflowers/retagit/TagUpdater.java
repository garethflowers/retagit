package garethflowers.retagit;

import java.awt.Cursor;

import javax.swing.JOptionPane;

/**
 * TagUpdater
 * 
 * @author Gareth Flowers <gareth@garethflowers.com>
 */
public class TagUpdater extends Thread {

	private Tag CurrentTag;
	private MainGUI Parent;

	public TagUpdater(MainGUI j, Tag current) {
		this.CurrentTag = current;
		this.Parent = j;
	}

	@Override
	public void run() {
		TagWriter writer = new TagWriter(this.CurrentTag);
		boolean written = writer.write();

		if (written) {
			this.CurrentTag = TagReader.read(this.CurrentTag.getFilename());
			Parent.setGuiFromCurrent();
		}

		Parent.Updating(false);
		Parent.LockGUI(false);
		Parent.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

		if (written) {
			JOptionPane.showMessageDialog(Parent, "Tag Updating Complete",
					"Complete", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(Parent, "Tag Updating Failed!",
					"Failed", JOptionPane.ERROR_MESSAGE);
		}
	}
}
