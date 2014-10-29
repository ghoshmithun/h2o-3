package water.api;

import water.api.ImportFilesHandler.ImportFiles;
import water.util.DocGen.HTML;

class ImportFilesV2 extends Schema<ImportFiles,ImportFilesV2> {

  // Input fields
  @API(help="path", required=true)
  String path;

  // Output fields
  @API(help="files", direction=API.Direction.OUTPUT)
  String files[];

  @API(help="keys", direction=API.Direction.OUTPUT)
  String keys[];

  @API(help="fails", direction=API.Direction.OUTPUT)
  String fails[];

  @API(help="dels", direction=API.Direction.OUTPUT)
  String dels[];

  //==========================
  // Custom adapters go here

  // Version&Schema-specific filling into the impl
  @Override public ImportFiles createImpl() {
    ImportFiles i = new ImportFiles();
    i._path = path;
    return i;
  }

  // Version&Schema-specific filling from the impl
  @Override public ImportFilesV2 fillFromImpl(ImportFiles i) {
    path  = i._path;
    files = i._files;
    keys  = i._keys ;
    fails = i._fails;
    dels  = i._dels ;
    return this;
  }

  @Override public HTML writeHTML_impl( HTML ab ) {
    ab.title("ImportFiles");
    if( keys.length == 0 )
      ab.putStr("path",path);
    else
      ab.href("path",path,water.parser.ParseSetupV2.link(keys));
    ab.putAStr("files",files);
    ab.putAStr( "keys", keys);
    ab.putAStr("fails",fails);
    ab.putAStr( "dels", dels);
    return ab;
  }
}
