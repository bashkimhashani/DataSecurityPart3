Universiteti Prishtinës Fakulteti i Inxhinierisë Elektrike dhe Kompjuterike Siguria e të dhënave Grupi 19 - Albena Mehmeti, Arijana Braha, Bashkim Hashani, Dua Gashi. Aplikacioni i cili bën Enkriptimin dhe Dekriptimin e të dhënave
përmes Algoritmit të Cesarit ose Vigenère.

Si funksionon? Programi përbëhet nga disa funksione kryesore që punojnë së bashku për të:

1. Struktura Kryesore

    Aplikacion JavaFX:

        Zgjat klasën Application për të krijuar një GUI (Graphical User Interface).

        Përdor BorderPane si rrjetë kryesore me 3 zona:

            Top: Fushat e hyrjes (çelësi, shtigjet e skedarëve).

            Center: Zona e tekstit për mesazhin.

            Bottom: Zgjedhja e algoritmit + butonat për enkriptim/dekriptim.

2. Përbërësit Kryesorë

    Fushat e Hyrjes:

        keyField: Pranon një çelës numerik (për Caesar) ose alfabetik (për Vigenère).

        filePathField / savePathField: Përdoren për të zgjedhur ku të hapet/ruhet skedari.

        messageArea: Shfrytëzuesi mund të shkruajë direkt tekstin ose të shohë rezultatin.

    ComboBox (algorithmBox):

        Mundëson zgjedhjen midis "Caesar" dhe "Vigenère".

    Butonat:

        Browse & Save As: Hapin FileChooser për zgjedhjen e skedarëve.

        Encrypt & Decrypt: Nisin procesin e enkriptimit/dekriptimit.

3. Logjika e Procesimit

    Metoda process(boolean encrypt):

        Kontrollon nëse përdoret skedari (filePathField) ose teksti direkt (messageArea).

        Nëse përdoret Caesar:

            Konverton çelësin në numër (Integer.parseInt()).

            Thërret caesarEncrypt() ose caesarDecrypt().

        Nëse përdoret Vigenère:

            Thërret vigenereEncrypt() ose vigenereDecrypt() me çelësin si string.

        Rezultati ruhet në skedar (nëse është specifikuar savePathField) ose shfaqet në messageArea.

4. Implementimi i Algoritmeve
A. Caesar Cipher

    Enkriptimi (caesarEncrypt)

        Çdo shkronjë zhvendoset përpara me vlerën e çelësit.

        P.sh., nëse çelësi është 3:

            A → D, B → E, ..., Z → C (për shkronjat e mëdha).

        Nëse kalon Z, kthehet te A (% 26 siguron këtë).

    Dekriptimi (caesarDecrypt)

        Përdor të njëjtin algoritëm, por me zhvendosje të kundërt (26 - key).

B. Vigenère Cipher

    Enkriptimi (vigenereEncrypt)

        Përdor një çelës alfabetik (p.sh., "KEY").

        Çdo shkronjë teksti zhvendoset nga vlera e shkronjës përkatëse të çelësit.

            P.sh., "HELLO" me çelës "ABC" → H+A, E+B, L+C, L+A, O+B.

    Dekriptimi (vigenereDecrypt)

        Zhvendosja bëhet prapa (- shift).

        + 26 siguron që të mos ketë numra negativë.
