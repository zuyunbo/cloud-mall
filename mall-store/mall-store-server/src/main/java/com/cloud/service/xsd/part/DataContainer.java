//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2021.03.03 时间 02:23:35 PM CST 
//


package com.cloud.service.xsd.part;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "part"
})
@XmlRootElement(name = "DataContainer")
public class DataContainer {

    @XmlElement(name = "Part", required = true)
    protected Part part;

    public Part getPart() {
        return part;
    }

    /**
     * 设置part属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Part }
     *     
     */
    public void setPart(Part value) {
        this.part = value;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "id",
        "name",
        "code",
        "partTypes",
        "drawings",
        "digifax",
        "changeOrder"
    })
    public static class Part {

        @XmlElement(name = "Id", required = true)
        protected Id id;
        @XmlElement(name = "Name", required = true)
        protected Name name;
        @XmlElement(name = "Code", required = true)
        protected Code code;
        @XmlElement(name = "PartTypes", required = true)
        protected PartTypes partTypes;
        @XmlElement(name = "Drawings", required = true)
        protected Drawings drawings;
        @XmlElement(name = "Digifax", required = true)
        protected Digifax digifax;
        @XmlElement(name = "ChangeOrder", required = true)
        protected ChangeOrder changeOrder;

        /**
         * 获取id属性的值。
         * 
         * @return
         *     possible object is
         *     {@link Id }
         *     
         */
        public Id getId() {
            return id;
        }

        /**
         * 设置id属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link Id }
         *     
         */
        public void setId(Id value) {
            this.id = value;
        }

        /**
         * 获取name属性的值。
         * 
         * @return
         *     possible object is
         *     {@link Name }
         *     
         */
        public Name getName() {
            return name;
        }

        /**
         * 设置name属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link Name }
         *     
         */
        public void setName(Name value) {
            this.name = value;
        }

        /**
         * 获取code属性的值。
         * 
         * @return
         *     possible object is
         *     {@link Code }
         *     
         */
        public Code getCode() {
            return code;
        }

        /**
         * 设置code属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link Code }
         *     
         */
        public void setCode(Code value) {
            this.code = value;
        }

        /**
         * 获取partTypes属性的值。
         * 
         * @return
         *     possible object is
         *     {@link PartTypes }
         *     
         */
        public PartTypes getPartTypes() {
            return partTypes;
        }

        /**
         * 设置partTypes属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link PartTypes }
         *     
         */
        public void setPartTypes(PartTypes value) {
            this.partTypes = value;
        }

        /**
         * 获取drawings属性的值。
         * 
         * @return
         *     possible object is
         *     {@link Drawings }
         *     
         */
        public Drawings getDrawings() {
            return drawings;
        }

        /**
         * 设置drawings属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link Drawings }
         *     
         */
        public void setDrawings(Drawings value) {
            this.drawings = value;
        }

        /**
         * 获取digifax属性的值。
         * 
         * @return
         *     possible object is
         *     {@link Digifax }
         *     
         */
        public Digifax getDigifax() {
            return digifax;
        }

        /**
         * 设置digifax属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link Digifax }
         *     
         */
        public void setDigifax(Digifax value) {
            this.digifax = value;
        }

        /**
         * 获取changeOrder属性的值。
         * 
         * @return
         *     possible object is
         *     {@link ChangeOrder }
         *     
         */
        public ChangeOrder getChangeOrder() {
            return changeOrder;
        }

        /**
         * 设置changeOrder属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link ChangeOrder }
         *     
         */
        public void setChangeOrder(ChangeOrder value) {
            this.changeOrder = value;
        }


        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "id",
            "number",
            "state",
            "effectiveDate"
        })
        public static class ChangeOrder {

            @XmlElement(name = "Id", required = true)
            protected Id id;
            @XmlElement(name = "Number", required = true)
            protected Number number;
            @XmlElement(required = true)
            protected State state;
            @XmlElement(name = "EffectiveDate", required = true)
            protected EffectiveDate effectiveDate;

            /**
             * 获取id属性的值。
             * 
             * @return
             *     possible object is
             *     {@link Id }
             *     
             */
            public Id getId() {
                return id;
            }

            /**
             * 设置id属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link Id }
             *     
             */
            public void setId(Id value) {
                this.id = value;
            }

            /**
             * 获取number属性的值。
             * 
             * @return
             *     possible object is
             *     {@link Number }
             *     
             */
            public Number getNumber() {
                return number;
            }

            /**
             * 设置number属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link Number }
             *     
             */
            public void setNumber(Number value) {
                this.number = value;
            }

            /**
             * 获取state属性的值。
             * 
             * @return
             *     possible object is
             *     {@link State }
             *     
             */
            public State getState() {
                return state;
            }

            /**
             * 设置state属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link State }
             *     
             */
            public void setState(State value) {
                this.state = value;
            }

            /**
             * 获取effectiveDate属性的值。
             * 
             * @return
             *     possible object is
             *     {@link EffectiveDate }
             *     
             */
            public EffectiveDate getEffectiveDate() {
                return effectiveDate;
            }

            /**
             * 设置effectiveDate属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link EffectiveDate }
             *     
             */
            public void setEffectiveDate(EffectiveDate value) {
                this.effectiveDate = value;
            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "effectiveDateString"
            })
            public static class EffectiveDate {

                @XmlElement(name = "EffectiveDateString", required = true)
                protected String effectiveDateString;

                /**
                 * 获取effectiveDateString属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getEffectiveDateString() {
                    return effectiveDateString;
                }

                /**
                 * 设置effectiveDateString属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setEffectiveDateString(String value) {
                    this.effectiveDateString = value;
                }

            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "characterString"
            })
            public static class Id {

                @XmlElement(name = "CharacterString")
                protected int characterString;

                /**
                 * 获取characterString属性的值。
                 * 
                 */
                public int getCharacterString() {
                    return characterString;
                }

                /**
                 * 设置characterString属性的值。
                 * 
                 */
                public void setCharacterString(int value) {
                    this.characterString = value;
                }

            }


            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "classString"
            })
            public static class Number {

                @XmlElement(name = "ClassString", required = true)
                protected String classString;

                /**
                 * 获取classString属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getClassString() {
                    return classString;
                }

                /**
                 * 设置classString属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setClassString(String value) {
                    this.classString = value;
                }

            }


            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "classString"
            })
            public static class State {

                @XmlElement(name = "ClassString", required = true)
                protected String classString;

                /**
                 * 获取classString属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getClassString() {
                    return classString;
                }

                /**
                 * 设置classString属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setClassString(String value) {
                    this.classString = value;
                }

            }

        }


        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "characterString"
        })
        public static class Code {

            @XmlElement(name = "CharacterString", required = true)
            protected String characterString;

            /**
             * 获取characterString属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCharacterString() {
                return characterString;
            }

            /**
             * 设置characterString属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCharacterString(String value) {
                this.characterString = value;
            }

        }



        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "id",
            "number",
            "weight",
            "developmentPhase"
        })
        public static class Digifax {

            @XmlElement(name = "Id", required = true)
            protected Id id;
            @XmlElement(name = "Number", required = true)
            protected Number number;
            @XmlElement(name = "Weight", required = true)
            protected Weight weight;
            @XmlElement(name = "DevelopmentPhase", required = true)
            protected DevelopmentPhase developmentPhase;

            /**
             * 获取id属性的值。
             * 
             * @return
             *     possible object is
             *     {@link Id }
             *     
             */
            public Id getId() {
                return id;
            }

            /**
             * 设置id属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link Id }
             *     
             */
            public void setId(Id value) {
                this.id = value;
            }

            /**
             * 获取number属性的值。
             * 
             * @return
             *     possible object is
             *     {@link Number }
             *     
             */
            public Number getNumber() {
                return number;
            }

            /**
             * 设置number属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link Number }
             *     
             */
            public void setNumber(Number value) {
                this.number = value;
            }

            /**
             * 获取weight属性的值。
             * 
             * @return
             *     possible object is
             *     {@link Weight }
             *     
             */
            public Weight getWeight() {
                return weight;
            }

            /**
             * 设置weight属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link Weight }
             *     
             */
            public void setWeight(Weight value) {
                this.weight = value;
            }

            /**
             * 获取developmentPhase属性的值。
             * 
             * @return
             *     possible object is
             *     {@link DevelopmentPhase }
             *     
             */
            public DevelopmentPhase getDevelopmentPhase() {
                return developmentPhase;
            }

            /**
             * 设置developmentPhase属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link DevelopmentPhase }
             *     
             */
            public void setDevelopmentPhase(DevelopmentPhase value) {
                this.developmentPhase = value;
            }



            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "phaseString"
            })
            public static class DevelopmentPhase {

                @XmlElement(name = "PhaseString", required = true)
                protected String phaseString;

                /**
                 * 获取phaseString属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getPhaseString() {
                    return phaseString;
                }

                /**
                 * 设置phaseString属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setPhaseString(String value) {
                    this.phaseString = value;
                }

            }


            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "characterString"
            })
            public static class Id {

                @XmlElement(name = "CharacterString")
                protected int characterString;

                /**
                 * 获取characterString属性的值。
                 * 
                 */
                public int getCharacterString() {
                    return characterString;
                }

                /**
                 * 设置characterString属性的值。
                 * 
                 */
                public void setCharacterString(int value) {
                    this.characterString = value;
                }

            }



            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "classString"
            })
            public static class Number {

                @XmlElement(name = "ClassString", required = true)
                protected String classString;

                /**
                 * 获取classString属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getClassString() {
                    return classString;
                }

                /**
                 * 设置classString属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setClassString(String value) {
                    this.classString = value;
                }

            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "numberString"
            })
            public static class Weight {

                @XmlElement(name = "NumberString")
                protected float numberString;

                /**
                 * 获取numberString属性的值。
                 * 
                 */
                public float getNumberString() {
                    return numberString;
                }

                /**
                 * 设置numberString属性的值。
                 * 
                 */
                public void setNumberString(float value) {
                    this.numberString = value;
                }

            }

        }



        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "versionNumberString"
        })
        public static class Drawings {

            @XmlElement(name = "VersionNumberString", required = true)
            protected String versionNumberString;

            /**
             * 获取versionNumberString属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getVersionNumberString() {
                return versionNumberString;
            }

            /**
             * 设置versionNumberString属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setVersionNumberString(String value) {
                this.versionNumberString = value;
            }

        }



        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "characterString"
        })
        public static class Id {

            @XmlElement(name = "CharacterString")
            protected int characterString;

            /**
             * 获取characterString属性的值。
             * 
             */
            public int getCharacterString() {
                return characterString;
            }

            /**
             * 设置characterString属性的值。
             * 
             */
            public void setCharacterString(int value) {
                this.characterString = value;
            }

        }



        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "characterString"
        })
        public static class Name {

            @XmlElement(name = "CharacterString", required = true)
            protected String characterString;

            /**
             * 获取characterString属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCharacterString() {
                return characterString;
            }

            /**
             * 设置characterString属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCharacterString(String value) {
                this.characterString = value;
            }

        }


        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "classString"
        })
        public static class PartTypes {

            @XmlElement(name = "ClassString", required = true)
            protected String classString;

            /**
             * 获取classString属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getClassString() {
                return classString;
            }

            /**
             * 设置classString属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setClassString(String value) {
                this.classString = value;
            }

        }

    }

}
