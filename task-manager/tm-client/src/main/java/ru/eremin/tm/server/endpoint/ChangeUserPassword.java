package ru.eremin.tm.server.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for changeUserPassword complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="changeUserPassword"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="arg0" type="{http://endpoint.server.tm.eremin.ru/}sessionDTO" minOccurs="0"/&gt;
 *         &lt;element name="arg1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="arg2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "changeUserPassword", propOrder = {
        "arg0",
        "arg1",
        "arg2"
})
public class ChangeUserPassword {

    protected SessionDTO arg0;
    protected String arg1;
    protected String arg2;

    /**
     * Gets the value of the arg0 property.
     *
     * @return possible object is
     * {@link SessionDTO }
     */
    public SessionDTO getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     *
     * @param value allowed object is
     *              {@link SessionDTO }
     */
    public void setArg0(SessionDTO value) {
        this.arg0 = value;
    }

    /**
     * Gets the value of the arg1 property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getArg1() {
        return arg1;
    }

    /**
     * Sets the value of the arg1 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setArg1(String value) {
        this.arg1 = value;
    }

    /**
     * Gets the value of the arg2 property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getArg2() {
        return arg2;
    }

    /**
     * Sets the value of the arg2 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setArg2(String value) {
        this.arg2 = value;
    }

}
