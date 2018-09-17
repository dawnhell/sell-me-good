import { NgModule } from '@angular/core';

import { MatButtonModule, MatGridListModule, MatToolbarModule } from '@angular/material';

@NgModule({
  imports: [
    MatToolbarModule,
    MatGridListModule,
    MatButtonModule
  ],
  exports: [
    MatToolbarModule,
    MatGridListModule,
    MatButtonModule
  ]
})

export class MaterialModule {}
