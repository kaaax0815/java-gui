package de.kaaaxcreators.swing;

import java.awt.Component;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.File;
import java.util.ArrayList;

public class DragAndDropHandler {
    // user should be able to drop an image on whole window
    static void handleDragAndDrop(Component _dragAndDropComponent) {
        new DropTarget(_dragAndDropComponent, new DropTargetListener() {
    	    @Override
    	    public void drop(DropTargetDropEvent dtde) {
        		try {
                    System.out.println("erreicht");
        		    Transferable tr = dtde.getTransferable();
        		    DataFlavor[] flavors = tr.getTransferDataFlavors();
        		    ArrayList<File> fileNames = new ArrayList<File>();
        		    for (int i = 0; i < flavors.length; i++) {
                        System.out.println(flavors.length);
                        // all the different flavors only have one single image file
            			if (flavors[i].isFlavorJavaFileListType()) {
                            System.out.println(flavors[i]);
            			    dtde.acceptDrop(dtde.getDropAction());
            			    @SuppressWarnings("unchecked")
            			    java.util.List<File> files = (java.util.List<File>) tr.getTransferData(flavors[i]);
            			    for (int k = 0; k < files.size(); k++) {
            				    fileNames.add(files.get(k));
            			    }
                            // as soon as path is found, update the views
                            App.filePath = fileNames.get(0);
                            System.out.println(App.filePath);
                            App.result.update();
                            App.select.update();

            			    dtde.dropComplete(true);
            			}
        		    }
        		    return;
        		}
        		catch (Throwable t) {
        		    t.printStackTrace();
        		}
        		dtde.rejectDrop();	
    	    }

            @Override public void dragEnter(DropTargetDragEvent dtde) {}
            @Override public void dragOver(DropTargetDragEvent dtde) {}
            @Override public void dropActionChanged(DropTargetDragEvent dtde) {}
            @Override public void dragExit(DropTargetEvent dte) {}
    	});
    }
}
