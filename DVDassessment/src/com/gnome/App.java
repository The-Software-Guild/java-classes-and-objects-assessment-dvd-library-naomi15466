package com.gnome;

import com.gnome.controller.DvdLibraryController;
import com.gnome.dao.DvdLibraryDaoFileImpl;
import com.gnome.dao.dvdLibraryDao;
import com.gnome.ui.DvdLibraryView;
import com.gnome.ui.UserIO;
import com.gnome.ui.UserIOConsoleImpl;

/**
 *
 * @author salajrawi
 */
public class App {

    public static void main(String[] args) {
        /*
        Instantiate the UserIO, DvdLibraryView,dvdLibraryDao,  DvdLibraryController class and call the run method
         */
        UserIO myIo = new UserIOConsoleImpl();
        DvdLibraryView view = new DvdLibraryView(myIo);
        dvdLibraryDao dao = new DvdLibraryDaoFileImpl();
        DvdLibraryController controller = new DvdLibraryController(view,dao);
        controller.run();


    }
}