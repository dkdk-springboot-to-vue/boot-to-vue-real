import { localAxios } from "@/util/http-commons";

const local = localAxios();

const url = "/board";

function listArticle(param, success, fail) {
  local.get(`${url}/list`, { params: param }).then(success).catch(fail);
}

function detailArticle(articleno, success, fail) {
  local.get(`${url}/view/${articleno}`).then(success).catch(fail);
}

export { listArticle, detailArticle };
