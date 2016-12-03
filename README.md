# ValidatorLayout
Librería de clases para validar archivos de texto plano, xlsx y csv.

<h3>Objetivo</h3>
<p>Crear una libreria en Java que nos permita validar la estructura de archivos de tipo bancario.</p>

<h3>Objetivo específicos</h3>
<ul>
<li>Aplicar el patrón de diseño de estrategía para poder agregar métodos de validación en nuevas clases.</li>
<li>Aplicar el patrón de fábrica para agregar nuevos tipos de archivos que puedan ser validados</li>
<li>Cargar configuración desde un XML.</li>
<li>Utilizar JUNIT para pruebas unitarias.</li>
</ul>

<h3>Características</h3>
<ul>
<li>Validación de estructura de archivos: fixed txt y xlsx </li>
<li>Uso de la librería POI para la lectura de xlsx</li>
<li>Uso JAXB para la sintaxis en la clases y carga de XML</li>
</ul>

<h3>Notas</h3>
<ul>
<li>El proyecto esta construido en Netbeans 8.1</li>
<li>Utiliza java 1.8</li>
<li>Utiliza POI.3.15</li>
</ul>

<h3>Estructura de clases</h3>
<p>Primero necesitamos la estructura configurable de un documento compuesto por registros y columnas, donde cada columna podría ser validada con uno o más metodos.<p>
<ul>
<li><b>ObjectValidatorInterface</b> En el nivel mas bajo tenemos una interface que implementa un método validate(String value)</li>
<li>Con el objetivo de implementar el patrón strategia tenemos tres clases que implemntan la interface<ol>
<li><b>ObjectDateValidator</b></li>
<li><b>ObjectTypeValidator</b></li>
<li><b>ObjectRegexValidator</b></li>
</ol></li>
<li><b>ItemValidator</b> tiene una lista de ObjectValidatorInterface para poder realizar más de una validación al valor.</li>
<li><b>RowValidator</b> tiene una lista de ItemValidator que vendrian siendo las columnas de un archivo.</li>
<li><b>DocumentValidator</b> tiene una lista de RowValidator ya que podría haber más de una tipo de renglón, cada tipo e renglón tiene su propia configuración de datos a validar.</li>
</ul>
<h3>Ejemplo para crear archivo de configuración desde las clases</h3>
<small>
DocumentValidator documentValidator=new DocumentValidator();
        documentValidator.setFlatFixedRowValue(new FlatFixedPositionValue(0,2));
        RowValidator itemsValidatorHeader=new RowValidator("01","Header");        
        itemsValidatorHeader.setFlatFixedTypeRow(new FlatFixedPositionValue(0,2,15));
        itemsValidatorHeader.addItemValidator(new ItemValidator("tipo",true,"Identifica el tipo de registro. ","Debe ser numérico y siempre debe de contener 01"));
        itemsValidatorHeader.getListItemValidator().get(0).setFlatFixedItemValue(new FlatFixedPositionValue(0,2));
        itemsValidatorHeader.getListItemValidator().get(0).addObjectValidatorInterface(new ObjectRegexValidator("01"));
        itemsValidatorHeader.addItemValidator(new ItemValidator("secuencia",true,"Número de registro incremental ascendente","Debe ser numérico"));
        itemsValidatorHeader.getListItemValidator().get(1).setFlatFixedItemValue(new FlatFixedPositionValue(2,7));
        itemsValidatorHeader.getListItemValidator().get(1).addObjectValidatorInterface(new ObjectRegexValidator("[0-9]{5}"));
        itemsValidatorHeader.addItemValidator(new ItemValidator("fecha",true,"Fecha actual","Fecha del dia de hoy"));
        itemsValidatorHeader.getListItemValidator().get(2).setFlatFixedItemValue(new FlatFixedPositionValue(7,15));
        itemsValidatorHeader.getListItemValidator().get(2).addObjectValidatorInterface(new ObjectDateValidator(TypeOperationDateEnum.TODAY,"ddMMyyyy",0));
        RowValidator itemsValidatorBody=new RowValidator("02","Body");
        itemsValidatorBody.setFlatFixedTypeRow(new FlatFixedPositionValue(0,2,32));
        itemsValidatorBody.addItemValidator(new ItemValidator("tipo",true,"Identifica el tipo de registro. ","Debe ser numérico y siempre debe de contener 02"));
        itemsValidatorBody.getListItemValidator().get(0).setFlatFixedItemValue(new FlatFixedPositionValue(0,2));
        itemsValidatorBody.getListItemValidator().get(0).addObjectValidatorInterface(new ObjectRegexValidator("02"));
        itemsValidatorBody.addItemValidator(new ItemValidator("secuencia",true,"Número de registro incremental ascendente","Debe ser numérico"));
        itemsValidatorBody.getListItemValidator().get(1).setFlatFixedItemValue(new FlatFixedPositionValue(2,7));
        itemsValidatorBody.getListItemValidator().get(1).addObjectValidatorInterface(new ObjectRegexValidator("[0-9]{5}"));
        itemsValidatorBody.addItemValidator(new ItemValidator("rfc",true,"RFC","RFC"));
        itemsValidatorBody.getListItemValidator().get(2).setFlatFixedItemValue(new FlatFixedPositionValue(7,20));
        itemsValidatorBody.getListItemValidator().get(2).addObjectValidatorInterface(new ObjectRegexValidator("^([A-Z,Ñ,&]{3,4}([0-9]{2})(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])[A-Z|\\d]{3})$"));
        itemsValidatorBody.addItemValidator(new ItemValidator("importe",true,"Es el monto de la transacción"," Debe estar informado y los últimos 2 dígitos serviran como decimales y no debe contener punto decimal"));
        itemsValidatorBody.getListItemValidator().get(3).setFlatFixedItemValue(new FlatFixedPositionValue(20,32));
        itemsValidatorBody.getListItemValidator().get(3).addObjectValidatorInterface(new ObjectRegexValidator("\\d{12}"));         
        RowValidator itemsValidatorFooter=new RowValidator("03","Footer");
        itemsValidatorFooter.setFlatFixedTypeRow(new FlatFixedPositionValue(0,2,19));
        itemsValidatorFooter.addItemValidator(new ItemValidator("tipo",true,"Identifica el tipo de registro. ","Debe ser numérico y siempre debe de contener 03"));
        itemsValidatorFooter.getListItemValidator().get(0).setFlatFixedItemValue(new FlatFixedPositionValue(0,2));
        itemsValidatorFooter.getListItemValidator().get(0).addObjectValidatorInterface(new ObjectRegexValidator("03"));
        itemsValidatorFooter.addItemValidator(new ItemValidator("secuencia",true,"Número de registro incremental ascendente","Debe ser numérico"));
        itemsValidatorFooter.getListItemValidator().get(1).setFlatFixedItemValue(new FlatFixedPositionValue(2,7));
        itemsValidatorFooter.getListItemValidator().get(1).addObjectValidatorInterface(new ObjectRegexValidator("[0-9]{5}"));
        itemsValidatorFooter.addItemValidator(new ItemValidator("total",true,"Es el monto total de todos los importes"," Debe estar informado y los últimos 2 dígitos serviran como decimales y no debe contener punto decimal"));
        itemsValidatorFooter.getListItemValidator().get(2).setFlatFixedItemValue(new FlatFixedPositionValue(7,19));
        itemsValidatorFooter.getListItemValidator().get(2).addObjectValidatorInterface(new ObjectRegexValidator("\\d{12}")); 

        documentValidator.addRowValidator(itemsValidatorHeader);
        documentValidator.addRowValidator(itemsValidatorBody);
        documentValidator.addRowValidator(itemsValidatorFooter);
        
        File f=new File("C:\\Users\\jgonzalezc\\Desktop\\ValidadorLayout\\DocumentoValidatorXLSX.xml");
        try{
            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw); 
            wr.write(JaxbValidatorConverter.createXmlFromObject(documentValidator));//escribimos en el archivo
            wr.close();
            bw.close();
        }catch(IOException e){};
</small>
<h3>Ejemplo de archivo de configuración en XML para un archivo fixed txt</h3>
<small><?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<DocumentValidator>
    <flatFixedRowValue positionBegin="0" positionEnd="2"/>
    <listRowValidator description="Header" name="01">
        <flatFixedTypeRow positionBegin="0" positionEnd="2" size="15"/>
        <listItemValidator description="Identifica el tipo de registro. " name="tipo" validate="true" validateFormat="Debe ser numérico y siempre debe de contener 01">
            <flatFixedItemValue positionBegin="0" positionEnd="2"/>
            <listObjectValidatorInterface xsi:type="objectRegexValidator" regularExpresion="01" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"/>
        </listItemValidator>
        <listItemValidator description="Número de registro incremental ascendente" name="secuencia" validate="true" validateFormat="Debe ser numérico">
            <flatFixedItemValue positionBegin="2" positionEnd="7"/>
            <listObjectValidatorInterface xsi:type="objectRegexValidator" regularExpresion="[0-9]{5}" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"/>
        </listItemValidator>
        <listItemValidator description="Fecha actual" name="fecha" validate="true" validateFormat="Fecha del dia de hoy">
            <flatFixedItemValue positionBegin="7" positionEnd="15"/>
            <listObjectValidatorInterface xsi:type="objectDateValidator" addless="0" format="ddMMyyyy" typeOperationDateEnum="TODAY" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"/>
        </listItemValidator>
    </listRowValidator>
    <listRowValidator description="Body" name="02">
        <flatFixedTypeRow positionBegin="0" positionEnd="2" size="32"/>
        <listItemValidator description="Identifica el tipo de registro. " name="tipo" validate="true" validateFormat="Debe ser numérico y siempre debe de contener 02">
            <flatFixedItemValue positionBegin="0" positionEnd="2"/>
            <listObjectValidatorInterface xsi:type="objectRegexValidator" regularExpresion="02" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"/>
        </listItemValidator>
        <listItemValidator description="Número de registro incremental ascendente" name="secuencia" validate="true" validateFormat="Debe ser numérico">
            <flatFixedItemValue positionBegin="2" positionEnd="7"/>
            <listObjectValidatorInterface xsi:type="objectRegexValidator" regularExpresion="[0-9]{5}" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"/>
        </listItemValidator>
        <listItemValidator description="RFC" name="rfc" validate="true" validateFormat="RFC">
            <flatFixedItemValue positionBegin="7" positionEnd="20"/>
            <listObjectValidatorInterface xsi:type="objectRegexValidator" regularExpresion="^([A-Z,Ñ,&amp;]{3,4}([0-9]{2})(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])[A-Z|\d]{3})$" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"/>
        </listItemValidator>
        <listItemValidator description="Es el monto de la transacción" name="importe" validate="true" validateFormat=" Debe estar informado y los últimos 2 dígitos serviran como decimales y no debe contener punto decimal">
            <flatFixedItemValue positionBegin="20" positionEnd="32"/>
            <listObjectValidatorInterface xsi:type="objectRegexValidator" regularExpresion="\d{12}" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"/>
        </listItemValidator>
    </listRowValidator>
    <listRowValidator description="Footer" name="03">
        <flatFixedTypeRow positionBegin="0" positionEnd="2" size="19"/>
        <listItemValidator description="Identifica el tipo de registro. " name="tipo" validate="true" validateFormat="Debe ser numérico y siempre debe de contener 03">
            <flatFixedItemValue positionBegin="0" positionEnd="2"/>
            <listObjectValidatorInterface xsi:type="objectRegexValidator" regularExpresion="03" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"/>
        </listItemValidator>
        <listItemValidator description="Número de registro incremental ascendente" name="secuencia" validate="true" validateFormat="Debe ser numérico">
            <flatFixedItemValue positionBegin="2" positionEnd="7"/>
            <listObjectValidatorInterface xsi:type="objectRegexValidator" regularExpresion="[0-9]{5}" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"/>
        </listItemValidator>
        <listItemValidator description="Es el monto total de todos los importes" name="total" validate="true" validateFormat=" Debe estar informado y los últimos 2 dígitos serviran como decimales y no debe contener punto decimal">
            <flatFixedItemValue positionBegin="7" positionEnd="19"/>
            <listObjectValidatorInterface xsi:type="objectRegexValidator" regularExpresion="\d{12}" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"/>
        </listItemValidator>
    </listRowValidator>
</DocumentValidator></small>
             
<h3>Recorrido de archivos</h3>
<p>Segundo necesitamos el recorrido de los diferentes tipos de archivos, para obtener sus valores y aplicar las validaciones el archivo de configuración.<p>
<ul>
<li><b>DocumentLayoutAbstract</b><ul>
<li><b>FlatFixedDocumentLayout</b></li>
<li><b>XLSXDocumentLayout</b></li>
</ul></li>
</ul>

