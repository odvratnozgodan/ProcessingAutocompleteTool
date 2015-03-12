/**
 * you can put a one sentence description of your tool here.
 *
 * ##copyright##
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General
 * Public License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA  02111-1307  USA
 * 
 * @author		##author##
 * @modified	##date##
 * @version		##tool.prettyVersion##
 */

package template.tool;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import processing.app.*;
import processing.app.tools.*;

public class AutocompleteTool implements Tool, KeyListener {

	Editor editor;
	final static DefaultListModel model = new DefaultListModel();
	static String content;
	int index;
	File api;

	// when creating a tool, the name of the main class which implements Tool
	// must be the same as the value defined for project.name in your
	// build.properties

	public String getMenuTitle() {
		return "##tool.name##";
	}

	public void init(Editor theEditor) {
		this.editor = theEditor;
	}

	public void run() {
		// Fill in author.name, author.url, tool.prettyVersion and
		// project.prettyName in
		// build.properties for them to be auto-replaced here.
		System.out.println("Autocomplete Tool. ##tool.name## ##tool.prettyVersion## by ##author##");
		JTextArea text = new JTextArea(100, 30);
		String line;
		content = editor.getText();
		int offest = editor.getCaretOffset();
		System.out.println("content:" + content + ", offset:" + Integer.toString(offest));
		this.editor.getTextArea().addKeyListener(this);
		// put the destination of the api file here
		// api = new File(""); put the api.txt file destination between quotes .
		// default will be in
		/*BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(api));
			line = in.readLine();
			while (line != null) {
				index = line.indexOf(content);
				if (index != -1) {
					model.addElement(line);
					text.append(line + "\n");
					line = in.readLine();
				} else {
					line = in.readLine();
				}
			}
		} catch (Exception ex) {
			System.out.println("Exception");
		}*/

		/*
		 * JFrame f = new JFrame("auto complete test"); JPanel upperPanel = new
		 * JPanel(); JPanel lowerPanel = new JPanel();
		 * f.getContentPane().add(upperPanel, "North"); upperPanel.add(text);
		 */
		/*JFrame frame = new JFrame("Auto complete dialog");
		JPanel panel = new JPanel();
		JList list = new JList(model);
		frame.setUndecorated(false);
		panel.add(list);
		frame.add(panel);
		frame.setSize(400, 400);
		frame.setVisible(true);
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JList list = (JList) evt.getSource();
				if (evt.getClickCount() == 2) {
					editor.setText((String) list.getSelectedValue());
				} else if (evt.getClickCount() == 3) { // Triple-click
					int index2 = list.locationToIndex(evt.getPoint());

				}
			}
		});*/

		/*
		 * f.pack(); f.setVisible(true);
		 */
		editor.setText("Deleted your code. What now?");
	}

	@Override
	public void keyPressed(KeyEvent e) {
//		System.out.println("keyPressed()");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("keyReleased()");
		if ((e.getKeyCode() == KeyEvent.VK_SPACE) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            System.out.println("woot!");
        }
	}

	@Override
	public void keyTyped(KeyEvent e) {
//		System.out.println("keyTyped()");
	}

}
