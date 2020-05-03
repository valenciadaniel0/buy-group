import i18n from "i18next";
import LanguageDetector from "i18next";
import es from "./es/common.json";

i18n.init({
  // we init with resources
  resources: {
    es: es
  },
  fallbackLng: "es",
  debug: false,

  // have a common namespace used around the full app
  ns: ["translations"],
  defaultNS: "translations",

  keySeparator: false, // we use content as keys

  interpolation: {    
    formatSeparator: ","
  },

  react: {
    wait: true
  }
});

export default i18n;