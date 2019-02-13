package Utils;

public class DataPool {
	static String a = "";

	public static void main(String[] args) {
		DataPool1();
	}

	public static void DataPool1() {
		try {
            /* FileInputStream file = new FileInputStream(new File("C:/Users/jmcruz/Desktop/Portal Web Andorra Telecom/DataPool/DataPool.xlsx"));
             @SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(file);
             XSSFSheet sheet = workbook.getSheetAt(0);
             ArrayList<Parameters> employeeList = new ArrayList<>();
             
             for(int i=sheet.getFirstRowNum()+1;i<=sheet.getLastRowNum();i++){
            	 Parameters e= new Parameters();
                 Row ro = sheet.getRow(i);
                for(int j = ro.getFirstCellNum(); j <= ro.getLastCellNum();j++){
                	     Cell ce = ro.getCell(j);
                  if(j==0){e.setColumna_A(ce.getStringCellValue()); }
                    if(j==1){e.setColumna_B(ce.getStringCellValue()); }
                    if(j==2){e.setColumna_C(ce.getStringCellValue()); }
                    if(j==3){e.setColumna_D(ce.getStringCellValue()); }
                    if(j==4){e.setColumna_E(ce.getStringCellValue()); }
                    if(j==5){e.setColumna_F(ce.getStringCellValue()); }
                    if(j==6){e.setColumna_G(ce.getStringCellValue()); }
                    if(j==7){e.setColumna_H(ce.getStringCellValue()); }
                    if(j==8){e.setColumna_I(ce.getStringCellValue()); }
                 }
                 employeeList.add(e);
             }
             for(Parameters emp: employeeList){
            	 System.out.println(emp.getColumna_A()+" - "+emp.getColumna_B()+" - "+emp.getColumna_C()  );
               //  setA(emp.getFirstName()); 
             }
             file.close();*/
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			System.err.println(e.getCause());
		}
	}
}	
	

