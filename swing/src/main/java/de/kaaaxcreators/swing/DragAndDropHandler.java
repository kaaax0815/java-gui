package de.kaaaxcreators.swing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.*;
import java.io.File;
import java.util.List;

import javax.swing.*;

public class DragAndDropHandler extends JPanel {
	JLabel jLabel;
	File selectedFile;
	public DragAndDropHandler() {
		setLayout(new BorderLayout());

		// html for word wrap
		jLabel = new JLabel("<html><p style=\"text-align: center\">Ziehen Sie ein Bild per Drag & Drop hierher</p></html>", JLabel.CENTER);
		jLabel.setPreferredSize(new Dimension(200, 200));
		handleDragAndDrop(jLabel);
		add(jLabel, BorderLayout.CENTER);
	}

	void update() {
		ImageIcon imageIcon = ImageUtils.ImageIconByAbsolutePath(selectedFile.getAbsolutePath());
		imageIcon.setImage(ImageUtils.resizeToHeight(imageIcon.getImage(), 200));
		jLabel.setIcon(imageIcon);
		jLabel.setText(null);
		jLabel.setToolTipText(selectedFile.getName());
		// use size of image
		jLabel.setPreferredSize(null);
	}

    void handleDragAndDrop(Component dragAndDropComponent) {
        new DropTarget(dragAndDropComponent, new DropTargetListener() {
    	    public void drop(DropTargetDropEvent dtde) {
				if (!dtde.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
		    		dtde.rejectDrop();
					return;
				}
				try {
					Transferable transferable = dtde.getTransferable();
					dtde.acceptDrop(dtde.getDropAction());
					Object transferData = transferable.getTransferData(DataFlavor.javaFileListFlavor);
					// unsafe cast but we know it's a List<File>
					@SuppressWarnings("unchecked")
					List<File> files = (List<File>)transferData;
					File file = files.get(0);
					
					if (!canAcceptFile(file)) {
						dtde.dropComplete(false);
						return;
					}

					selectedFile = file;

					update();

					dtde.dropComplete(true);
					return;
				}
				catch (Exception ex) {
					ex.printStackTrace();
					dtde.dropComplete(false);
				}
    	    }

            public void dragEnter(DropTargetDragEvent dtde) {}
            public void dragOver(DropTargetDragEvent dtde) {}
            public void dropActionChanged(DropTargetDragEvent dtde) {}
            public void dragExit(DropTargetEvent dte) {}
    	});
    }

	boolean canAcceptFile(File file) {
		String[] allowedExtensions = { "jpg", "jpeg", "png", "gif" };
		for (String extension : allowedExtensions) {
			if (file.getName().toLowerCase().endsWith(extension)) {
				return true;
			}
		}
		return false;
	}
}
