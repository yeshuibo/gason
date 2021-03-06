/*
    GASON: SQLmap Wrapper for Burpsuite.
    Copyright (C) 2011-2012  Daniel Garcia (cr0hn) | dani@iniqua.com | twitter: @ggdaniel
    Project page: http://code.google.com/p/gason/

    This program is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public License
    as published by the Free Software Foundation; either version 2
    of the License, or (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program; if not, write to the Free Software
    Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package CustomPlugin;

import CustomPlugin.sqlmap.sqlmapGUI;
import burp.IHttpRequestResponse;
import java.util.logging.Level;
import java.util.logging.Logger;


public class sqlmapplugin extends HTTPDataTransform implements IPlugin {


    private static sqlmapplugin _instance = new sqlmapplugin();

    private sqlmapGUI _frame;

    /*
     * Singleton pattern
     */
    private sqlmapplugin()
    {
        this._frame = new sqlmapGUI();
    }

    public static sqlmapplugin getInstance()
    {
        return sqlmapplugin._instance;
    }
    // End singleton pattern

    @Override
    public void AddURL(IHttpRequestResponse URLs) {
        
        try {

            this._frame.AddURL(URLs);

            if (!this._frame.isVisible())
            {
                this._frame.setVisible(true);
                this._frame.requestFocus();
            }else{
                this._frame.setVisible(false);
                this._frame.setVisible(true);
                this._frame.requestFocus();
            }

        } catch (Exception ex) {
            Logger.getLogger(sqlmapplugin.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
}
