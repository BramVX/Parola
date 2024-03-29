package org.example.dictionary;

public class ExternalDictionaryAdapter implements IAdapterDictionary{
    @Override
    public boolean checkWord(String word) {
        ExternalDictionaryLibrary externalDictionaryLibrary = new ExternalDictionaryLibrary();
        return externalDictionaryLibrary.checkWord(word);
    }
}
