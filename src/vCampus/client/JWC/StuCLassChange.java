package vCampus.client.JWC;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.EventObject;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.event.CellEditorListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;


public class StuCLassChange extends JPanel{
	//表格数据
	Object[][] data= {{"","","","","","","",""}};
	
	//表格对象
	JTable tableDemo;
	TableColumn column;
	
	//弹出窗口的对象
	JFrame mesFrame;
	JTextArea ta;
	
	Font font1=new Font("苹方 常规",Font.CENTER_BASELINE,25);//设置字体格式和大小
	Font font2=new Font("苹方 常规",Font.CENTER_BASELINE,15);//设置字体格式和大小
	Font font3=new Font("苹方 常规",Font.CENTER_BASELINE,10);//设置字体格式和大小
	//************************************************
	//加入要显示数据
	private void setData() {
		Object[][] a= {{"","","","","",""},
				{"","","","","",""},
				{"","","","","",""},
				{"","","","","",""},
				{"","","","","",""},
				{"","","","","",""},
				{"","","","","",""}
				};
		data=a;
	}
	
	StuCLassChange(){
		super();
		//this.setBounds(0, 0, 200, 150);
		this.setLayout(new BorderLayout());
		setData();

	//	this.setLayout(null);
		this.setSize(1650,1000);         
	    	
		tableDemo=new JTable(new MyTableModel(data));
		
		tableDemo.setPreferredScrollableViewportSize(new Dimension(1000,1650));
		tableDemo.setFillsViewportHeight(true);
		
		JTableHeader head=tableDemo.getTableHeader();
		head.setFont(font1);
		//禁止改变列宽
		tableDemo.getTableHeader().setResizingAllowed(false);
		//禁止改变列顺序
		tableDemo.getTableHeader().setReorderingAllowed(false);
		//禁止自动改变大小
		tableDemo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		//确定列宽
		column = null;
		for (int i = 0; i <5 ; i++) {
		    column = tableDemo.getColumnModel().getColumn(i);
		   if(i==0||i==2) {
			   column.setPreferredWidth(250);
		   }
		   else
		        column.setPreferredWidth(150);
		    
		}
		
		//设置行高
		for(int i=0;i<7;i++) {
			
				tableDemo.setRowHeight(i, 40);
		
				
			
		}
		
		//添加渲染器
		
	    tableDemo.getColumnModel().getColumn(0).setCellRenderer(new TipsRenderer());
		tableDemo.getColumnModel().getColumn(5).setCellRenderer(new CourseChooseRenderer());
		tableDemo.getColumnModel().getColumn(1).setCellRenderer(new TipsRenderer());
		tableDemo.getColumnModel().getColumn(2).setCellRenderer(new TipsRenderer());
		tableDemo.getColumnModel().getColumn(3).setCellRenderer(new TipsRenderer());
		tableDemo.getColumnModel().getColumn(4).setCellRenderer(new TipsRenderer());
		 tableDemo.getColumnModel().getColumn(5).setCellEditor(new CourseChooseEditor());
		//TableColumn tc=tableDemo.getColumn("时间");
		
		 
		tableDemo.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				 java.awt.Point p = e.getPoint();
				int rowIndex = tableDemo.rowAtPoint(p);
		        int colIndex = tableDemo.columnAtPoint(p);
		        if(colIndex<3) {
		        	mesFrame=new JFrame();
		        	mesFrame.addWindowListener(new WindowAdapter() {
		        		public void windowClosing(WindowEvent e) {
		        			mesFrame.dispose();
		        		}
		        	});
		        	ta=new JTextArea();
		        	ta.setLineWrap(true);
		        	mesFrame.setLayout(new BorderLayout());
		        	mesFrame.add(ta, BorderLayout.CENTER);
		        	mesFrame.setBounds(300, 300, 200, 150);
		        	mesFrame.setVisible(true);
		        }
				
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		
		//scrollTable.add(tableDemo);
		JScrollPane scrollTable=new JScrollPane();
		scrollTable.setViewportView(tableDemo);
		
		this.add(scrollTable,BorderLayout.CENTER);
		
		
		
		this.setOpaque(true);
		JFrame frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(this);
		//myTable.pack();
		frame.setVisible(true);
		frame.setSize(1650, 1000);
		
	}
	
	//TableModel的类，继承于AbstractTableModel
	class MyTableModel extends AbstractTableModel{
		//表格要显示的数据
		//表头
		private String[] columnHead= {"课程名称","教师","时间","院系","学分",""};
		
		//数据
		private Object[][] data=null;
		
		MyTableModel(Object[][] a){
			data=a;
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return columnHead.length;
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return data.length;
		}

		@Override
		public Object getValueAt(int col, int row) {
			// TODO Auto-generated method stub
			return data[col][row];
		}
		
		public String getColumnName(int col,int row) {
			return columnHead[col];
		}
		
		public boolean isCellEditable(int row,int column) {
				if(column==5)
				{
					return true;
				}
				else {
					return false;
				}
			
		}
		
		public String getColumnName(int row)
		{
			return columnHead[row];
		}
	}
	
	//设置渲染器，使其能显示tips
	class TipsRenderer extends JLabel implements TableCellRenderer{

		@Override
		public Component getTableCellRendererComponent(JTable table, Object arg1, boolean isSelected, boolean hasFoucesed, int row,
				int col) {
			// TODO Auto-generated method stub
			
				this.setText(String.valueOf(table.getValueAt(row, col)));
				this.setOpaque(true);
				this.setToolTipText(String.valueOf(table.getValueAt(row, col)));
				this.setFont(font3);
				
			
			this.setHorizontalAlignment(CENTER);
			this.setVerticalAlignment(CENTER);
			
			return this;
		}
		
	}
	
	//设置选课按钮渲染器
	class CourseChooseRenderer extends JPanel implements TableCellRenderer{
		JButton choose,exit;
		JPanel pane;
		boolean chosen=false;
		@Override
		public Component getTableCellRendererComponent(JTable arg0, Object arg1, boolean arg2, boolean arg3, int row,
				int col) {
			// TODO Auto-generated method stub
			pane=new JPanel();
			choose=new JButton("选课");
			exit=new JButton("退课");
			choose.setSize(35, 10);
			exit.setSize(35, 10);
			pane.setSize(100, 30);
			//pane.setLayout(new BorderLayout());
			pane.add(choose);
			pane.add(exit);
			chosen=false;
			if(chosen==true) {
				choose.setVisible(false);
				
			}
			else
			{
				exit.setVisible(false);
			}
			return pane;
		}
		
	}
	
	//设置编辑器
	class CourseChooseEditor extends AbstractTableModel implements TableCellEditor{
		JButton choose,exit;
		JPanel pane;
		boolean chosen=false;

		@Override
		public void addCellEditorListener(CellEditorListener arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void cancelCellEditing() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Object getCellEditorValue() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isCellEditable(EventObject arg0) {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public void removeCellEditorListener(CellEditorListener arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean shouldSelectCell(EventObject arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean stopCellEditing() {
			// TODO Auto-generated method stub
			fireEditingStopped();
			return true;
		}
		
		 private void fireEditingStopped(){
			 
		 }

		@Override
		public Component getTableCellEditorComponent(JTable table, Object arg1, boolean arg2, int row, int col) {
			// TODO Auto-generated method stub
			JButton choose,exit;
			JPanel pane;
			boolean chosen=true;
			pane=new JPanel();
			choose=new JButton("选课");
			exit=new JButton("退课");
			choose.setSize(35, 10);
			exit.setSize(35, 10);
			pane.setSize(100, 30);
			//pane.setLayout(new BorderLayout());
			pane.add(choose);
			pane.add(exit);
			exit.setVisible(false);
			//fireTableCellUpdated();
			
			exit.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//************************在此处添加与数据可连接代码
					
					//***********************************************
					choose.setVisible(true);
					exit.setVisible(false);
					
					fireTableCellUpdated(row,col);
					fireEditingStopped();
					
				}
				
			});
			
			choose.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//************************在此处添加与数据可连接代码
					
					//***********************************************
					choose.setVisible(false);
					exit.setVisible(true);
					fireTableCellUpdated(col,row);
					fireEditingStopped();
					
				}
				
			});
			
			return pane;
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Object getValueAt(int arg0, int arg1) {
			// TODO Auto-generated method stub
			return null;
		}
		
		
	}
	
	public static void main(String args[]) {
		StuCLassChange table=new StuCLassChange();
	
	}

}
