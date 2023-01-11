import React from "react";

import { observer, inject } from "mobx-react";

const test = inject("appStore")(
  observer(({ appStore }) => {
    console.log(appStore.getTest());

    return <></>;
  })
);

export default test;
