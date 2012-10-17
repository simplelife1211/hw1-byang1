

/* First created by JCasGen Wed Oct 10 09:38:36 GMT-04:00 2012 */
package hw1.byang1.annotation;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.DocumentAnnotation;


import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Thu Oct 11 23:07:30 GMT-04:00 2012
 * XML source: F:/Project/11791/hw1-byang1/src/main/resources/descriptor/annotator/SimpleGeneAnnotator.xml
 * @generated */
public class NamedEntity extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(NamedEntity.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected NamedEntity() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public NamedEntity(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public NamedEntity(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public NamedEntity(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
  //*--------------*
  //* Feature: id

  /** getter for id - gets NamedEntity ID
   * @generated */
  public String getId() {
    if (NamedEntity_Type.featOkTst && ((NamedEntity_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "hw1.byang1.annotation.NamedEntity");
    return jcasType.ll_cas.ll_getStringValue(addr, ((NamedEntity_Type)jcasType).casFeatCode_id);}
    
  /** setter for id - sets NamedEntity ID 
   * @generated */
  public void setId(String v) {
    if (NamedEntity_Type.featOkTst && ((NamedEntity_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "hw1.byang1.annotation.NamedEntity");
    jcasType.ll_cas.ll_setStringValue(addr, ((NamedEntity_Type)jcasType).casFeatCode_id, v);}    
   
    
  //*--------------*
  //* Feature: content

  /** getter for content - gets Store matched string.
   * @generated */
  public String getContent() {
    if (NamedEntity_Type.featOkTst && ((NamedEntity_Type)jcasType).casFeat_content == null)
      jcasType.jcas.throwFeatMissing("content", "hw1.byang1.annotation.NamedEntity");
    return jcasType.ll_cas.ll_getStringValue(addr, ((NamedEntity_Type)jcasType).casFeatCode_content);}
    
  /** setter for content - sets Store matched string. 
   * @generated */
  public void setContent(String v) {
    if (NamedEntity_Type.featOkTst && ((NamedEntity_Type)jcasType).casFeat_content == null)
      jcasType.jcas.throwFeatMissing("content", "hw1.byang1.annotation.NamedEntity");
    jcasType.ll_cas.ll_setStringValue(addr, ((NamedEntity_Type)jcasType).casFeatCode_content, v);}    
  }

    